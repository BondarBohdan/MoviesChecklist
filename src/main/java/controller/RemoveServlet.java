package controller;

import dao.UserHasMovieDAO;
import entity.UserCredentials;
import service.UserHasMovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserCredentials userCredentials = (UserCredentials) session.getAttribute("userCredentials");
        UserHasMovieDAO userHasMovieDAO = new UserHasMovieService();
        int movieId = Integer.parseInt(req.getParameter("id"));

        userHasMovieDAO.remove(userCredentials.getId(), movieId);

        resp.sendRedirect("/MoviesChecklistEE_war_exploded/mymovies");
    }
}
