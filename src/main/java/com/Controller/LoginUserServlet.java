package com.Controller;

import com.DAO.LoginUserDAO;
import com.Model.Admin;
import com.Model.Customer;
import com.Model.Photographer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 *
 * @author irfan
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {

    private LoginUserDAO loginuserDAO;

    @Override
    public void init() {
        loginuserDAO = new LoginUserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/loginUser":
                    loginUser(request, response);
                    break;
                case "/signupCust":
                    signupCust(request, response);
                    break;
                case "/logoutUser":
                    logoutUser(request, response);
                    break;
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("usertype");
        Admin loginAdmin;
        Photographer loginPh;
        Customer loginCust;
        //if else for user type
        if (type.equals("admin")) {
            loginAdmin = loginuserDAO.loginAdmin(username, password);
            if (loginAdmin.isAdminLogIn() == true) {
                request.setAttribute("adminUsername", username);
                request.setAttribute("adminId", loginAdmin.getAdminId());
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginUser.jsp");
                request.setAttribute("errorMsg", "invalid username or password");
                dispatcher.forward(request, response);
            }
        } else if (type.equals("ph")) {
            loginPh = loginuserDAO.loginPh(username, password);
            if (loginPh.isPhLogIn() == true) {
                request.setAttribute("ph", loginPh);
                RequestDispatcher dispatcher = request.getRequestDispatcher("PhDashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginUser.jsp");
                request.setAttribute("errorMsg", "invalid username or password");
                dispatcher.forward(request, response);
            }
        } else if (type.equals("cust")) {
            loginCust = loginuserDAO.loginCust(username, password);
            if (loginCust.isCustLogIn() == true) {
                request.setAttribute("custUsername", username);
                request.setAttribute("custId", loginCust.getCustId());
                RequestDispatcher dispatcher = request.getRequestDispatcher("CustDashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginUser.jsp");
                request.setAttribute("errorMsg", "invalid username or password");
                dispatcher.forward(request, response);
            }
        }

    }

    private void signupCust(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String custName = request.getParameter("fullname");
        String custContact = request.getParameter("contact");
        String custEmail = request.getParameter("email");
        String custUsername = request.getParameter("username");
        String custPass = request.getParameter("password");
        String confirmPass = request.getParameter("confirmPassword");
        Customer currentCust = new Customer(custName, custContact, custEmail, custUsername, custPass);
        ServletContext sc = getServletContext();
        Customer usernameapproval = loginuserDAO.checkCust(custUsername);
        if (usernameapproval.isCustLogIn() == true) {
            if (custPass.equals(confirmPass)) {
                Customer newCust = new Customer(custName, custContact, custEmail, custUsername, custPass);
                loginuserDAO.insertCust(newCust);
                RequestDispatcher dispatcher = sc.getRequestDispatcher("/LoginUser.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = sc.getRequestDispatcher("/SignUp.jsp");
                request.setAttribute("details", currentCust);
                request.setAttribute("errorPass", "invalid password");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = sc.getRequestDispatcher("/SignUp.jsp");
            request.setAttribute("details", currentCust);
            request.setAttribute("errorUsername", "username taken");
            dispatcher.forward(request, response);
        }
    }
    
    private void newPhPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldPass = request.getParameter("oldPass");
    }
    
    private void newCustPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    private void newAdminPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate(); // This will end the user's session
        }

        // Redirect to the login page after logout
        response.sendRedirect(request.getContextPath() + "/LoginUser.jsp");
    }

}
