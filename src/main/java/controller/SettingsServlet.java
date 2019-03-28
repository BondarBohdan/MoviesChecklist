package controller;

import constant.PageURL;
import constant.ServletURL;
import dao.UserDAO;
import entity.User;
import entity.UserCredentials;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {
    private HttpSession session;
    private UserDAO userDAO = new UserService();
    private UserCredentials userCredentials;
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        session = req.getSession();
        userCredentials = (UserCredentials) session.getAttribute("userCredentials");
        user = userDAO.getById(userCredentials.getId());

        req.setAttribute("user", user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.SETTINGS.getUrl());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));

        userDAO.update(user);

        resp.sendRedirect(ServletURL.SETTINGS.getUrl());
    }
}
