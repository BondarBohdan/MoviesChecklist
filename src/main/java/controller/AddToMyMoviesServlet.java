package controller;

import constant.ServletURL;
import dao.UserHasMovieDAO;
import entity.UserCredentials;
import service.UserHasMovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addToMyMovies")
public class AddToMyMoviesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserCredentials userCredentials = (UserCredentials) session.getAttribute("userCredentials");
        UserHasMovieDAO userHasMovieDAO = new UserHasMovieService();
        int movieId = Integer.parseInt(req.getParameter("id"));
        String forwardParams = "?start=" + req.getParameter("start");


        if (!userHasMovieDAO.existenceChecker(userCredentials.getId(), movieId)) {
            userHasMovieDAO.add(userCredentials.getId(), movieId);
        }
        resp.sendRedirect(ServletURL.LIBRARY.getUrl() + forwardParams);

    }
}
