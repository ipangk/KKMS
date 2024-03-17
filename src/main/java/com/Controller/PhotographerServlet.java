package com.Controller;

import com.DAO.PhotographerDAO;
import com.Model.Photographer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author irfan
 */
@WebServlet("/PhotographerServlet")
public class PhotographerServlet extends HttpServlet {

    private PhotographerDAO phDAO;

    @Override
    public void init() {
        phDAO = new PhotographerDAO();
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
                case "/listph":
                    listPh(request, response);
                    break;
                case "/addph":
                    addPh(request, response);
                    break;
                case "/insertph":
                    insertPh(request, response);
                    break;
                case "/editph":
                    editPh(request, response);
                    break;
                case "/editphph":
                    editPhPh(request, response);
                    break;
                case "/updateph":
                    updatePh(request, response);
                    break;
                case "/updatephph":
                    updatePhPh(request, response);
                    break;
                case "/deleteph":
                    deletePh(request, response);
                    break;
                case "/phdashboard":
                    phDashboard(request, response);
                    break;

            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listPh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Photographer> listph = phDAO.selectAllPh();
        getServletContext().setAttribute("listph", listph);
        ServletContext sc = getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/AdminPhList.jsp");
        dispatcher.forward(request, response);
    }

    private void addPh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        ServletContext sc = getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/AdminPhForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String phName = request.getParameter("phName");
        String phContact = request.getParameter("phContact");
        String phEmail = request.getParameter("phEmail");
        String phUsername = request.getParameter("phUsername");
        String phPass = request.getParameter("phContact");
        Photographer newph = new Photographer(phName, phContact, phEmail, phUsername, phPass);
        phDAO.insertPh(newph);
        response.sendRedirect("listph");
    }

    private void editPh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int phId = Integer.parseInt(request.getParameter("phId"));
        ServletContext sc = getServletContext();
        Photographer existingph = phDAO.selectPh(phId);
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/AdminPhForm.jsp");
        request.setAttribute("ph", existingph);
        dispatcher.forward(request, response);
    }

    private void editPhPh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int phId = Integer.parseInt(request.getParameter("phId"));
        ServletContext sc = getServletContext();
        Photographer existingph = phDAO.selectPh(phId);
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/PhProfileForm.jsp");
        request.setAttribute("ph", existingph);
        dispatcher.forward(request, response);
    }

    private void updatePh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int phId = Integer.parseInt(request.getParameter("phId"));
        String phName = request.getParameter("phName");
        String phContact = request.getParameter("phContact");
        String phEmail = request.getParameter("phEmail");
        String phUsername = request.getParameter("phUsername");
        String phPass = request.getParameter("phContact");
        Photographer newph = new Photographer(phId, phName, phContact, phEmail, phUsername, phPass);
        phDAO.updatePh(newph);
        response.sendRedirect("listph");
    }

    private void updatePhPh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int phId = Integer.parseInt(request.getParameter("phId"));
        String phName = request.getParameter("phName");
        String phContact = request.getParameter("phContact");
        String phEmail = request.getParameter("phEmail");
        String phUsername = request.getParameter("phUsername");
        String phPass = request.getParameter("phPass");
        Photographer newph = new Photographer(phId, phName, phContact, phEmail, phUsername, phPass);
        phDAO.updatePhPh(newph);
        ServletContext sc = getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/phdashboard");
        request.setAttribute("ph", newph);
        dispatcher.forward(request, response);
    }

    private void deletePh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int phId = Integer.parseInt(request.getParameter("phId"));
        phDAO.deletePh(phId);
        response.sendRedirect("listph");
    }

    private void phDashboard(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int phId = Integer.parseInt(request.getParameter("phId"));
        ServletContext sc = getServletContext();
        Photographer existingph = phDAO.selectPh(phId);
        request.setAttribute("ph", existingph);
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/PhDashboard.jsp");
        dispatcher.forward(request, response);

    }

}
