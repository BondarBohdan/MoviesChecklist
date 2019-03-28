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

@WebServlet("/setWatched")
public class SetWatchedServlet extends HttpServlet {
    private UserHasMovieDAO userHasMovieDAO = new UserHasMovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserCredentials userCredentials = (UserCredentials) session.getAttribute("userCredentials");
        int userId = userCredentials.getId();
        int movieId = Integer.parseInt(req.getParameter("id"));
        boolean isWatched = (Boolean.parseBoolean(req.getParameter("isWatched")) ? false : true);

        String forwardParams = "?start=" + req.getParameter("start");

        userHasMovieDAO.update(userId, movieId, isWatched);

        resp.sendRedirect(ServletURL.MY_MOVIES.getUrl() + forwardParams);
    }
}
