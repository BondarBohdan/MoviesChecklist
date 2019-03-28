package filter;

import constant.PageURL;
import entity.UserCredentials;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/editMovie.jsp", "/addNewMovie.jsp", "/editMovie", "/addNewMovie", "/deleteMovie"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        UserCredentials user = (UserCredentials) session.getAttribute("userCredentials");

        if (user != null && user.isAdmin()) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + PageURL.ACCESS_DENIED.getUrl());
        }

    }

    @Override
    public void destroy() {

    }
}
