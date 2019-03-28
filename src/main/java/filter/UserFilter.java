package filter;

import constant.ServletURL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/settings.jsp", "/myMovies.jsp", "/addToMyMovies.jsp", "/settings", "/myMovies", "/addToMyMovies", "/setWatched"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if (session.getAttribute("userCredentials") != null) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(ServletURL.LOG_IN.getUrl());
        }

    }

    @Override
    public void destroy() {

    }
}
