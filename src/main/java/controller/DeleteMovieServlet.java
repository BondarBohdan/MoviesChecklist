package controller;

import constant.ServletURL;
import dao.MovieDAO;
import service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MovieDAO movieDAO = new MovieService();
        int movieId = Integer.parseInt(req.getParameter("id"));
        String forwardParams = "?start=" + req.getParameter("start");

        movieDAO.remove(movieId);

        resp.sendRedirect(ServletURL.LIBRARY.getUrl() + forwardParams);
    }
}
