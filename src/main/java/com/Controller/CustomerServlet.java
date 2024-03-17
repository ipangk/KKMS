package com.Controller;

import com.DAO.CustomerDAO;
import com.DAO.LoginUserDAO;
import com.Model.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author irfan
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    private CustomerDAO custDAO;
    private LoginUserDAO loginuserDAO;

    @Override
    public void init() {
        custDAO = new CustomerDAO();
        loginuserDAO = new LoginUserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        doGet(request, response);
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
                case "/profilecust":
                    profileCust(request, response);
                    break;
                case "/editcust":
                    editCust(request, response);
                    break;
                case "/updatecust":
                    updatecust(request, response);
                    break;
                case "/deletecust":
                    deleteCust(request, response);
                    break;
                case "/custdashboard":
                    custDashboard(request, response);
                    break;
                default:
                    profileCust(request, response);

            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void profileCust(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int custId = Integer.parseInt(request.getParameter("custId"));
        ServletContext sc = getServletContext();
        Customer custDetail = custDAO.selectCust(custId);
        request.setAttribute("cust", custDetail);
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileDisplay.jsp");
        dispatcher.forward(request, response);
    }

    private void editCust(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int custId = Integer.parseInt(request.getParameter("custId"));
        ServletContext sc = getServletContext();
        Customer existingcust = custDAO.selectCust(custId);
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileForm.jsp");
        request.setAttribute("cust", existingcust);
        dispatcher.forward(request, response);
    }

    private void updatecust(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int custId = Integer.parseInt(request.getParameter("custId"));
        String custName = request.getParameter("custName");
        String custContact = request.getParameter("custContact");
        String custEmail = request.getParameter("custEmail");
        String custUsername = request.getParameter("custUsername");
        String custOriUsername = request.getParameter("custOriUsername");
        System.out.println("-------------------------");
        System.out.println(custOriUsername);
        System.out.println("-------------------------");
        String custPass = request.getParameter("custPass");
        String confirmPass = request.getParameter("confirmPassword");
        Customer newcust = new Customer(custId, custName, custContact, custEmail, custUsername, custPass);
        Customer usernameapproval = loginuserDAO.checkCust(custUsername);
        ServletContext sc = getServletContext();
        if (usernameapproval.isCustLogIn() == true) {
            System.out.println("custUsername");
            System.out.println("usernameapproval.getCustUsername()");
            if (custPass.equals(confirmPass)) {
                custDAO.updateCust(newcust);
                Customer existingcust = custDAO.selectCust(custId);
                RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileDisplay.jsp");
                request.setAttribute("cust", existingcust);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileForm.jsp");
                request.setAttribute("cust", newcust);
                request.setAttribute("errorPass", "invalid password");
                dispatcher.forward(request, response);
            }
        } else {
            if (custUsername.equals(custOriUsername) && usernameapproval.isCustLogIn() == false) {
                if (custPass.equals(confirmPass)) {
                    custDAO.updateCust(newcust);
                    Customer existingcust = custDAO.selectCust(custId);
                    RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileDisplay.jsp");
                    request.setAttribute("cust", existingcust);
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileForm.jsp");
                    request.setAttribute("cust", newcust);
                    request.setAttribute("errorPass", "invalid password");
                    dispatcher.forward(request, response);
                }
            } else {
                RequestDispatcher dispatcher = sc.getRequestDispatcher("/CustProfileForm.jsp");
                request.setAttribute("cust", newcust);
                request.setAttribute("errorUsername", "username taken");
                dispatcher.forward(request, response);
            }

        }
    }

    private void deleteCust(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int custId = Integer.parseInt(request.getParameter("custId"));
        custDAO.deleteCust(custId);
        response.sendRedirect("profilecust");
    }

    private void custDashboard(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int custId = Integer.parseInt(request.getParameter("custId"));
        request.setAttribute("custId", custId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustDashboard.jsp");
        dispatcher.forward(request, response);
    }

}
