package iuh.fit.se.ltwww_java_28082025_tuan02_tophangiabao;

import jakarta.servlet.*;
import java.io.IOException;

public class Bai1 implements Filter {
    private String username;
    private String password;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        username = filterConfig.getInitParameter("username");
        password = filterConfig.getInitParameter("password");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       String user = servletRequest.getParameter("usernameHTML");
       String pass = servletRequest.getParameter("passwordHTML");

       if (user!= null && user.equals(username) && pass!=null && pass.equals(password)) {
           filterChain.doFilter(servletRequest, servletResponse);

       } else {
           servletResponse.getWriter().write("<h1 style='color:red'>" + "Uh oh! seem like you type your username or password wrong " + "</h1>");
           servletResponse.getWriter().write("<a href='login.html'>" + "Click here to return login page" +"</a>");
       }

    }

    @Override
    public void destroy() {
    }
}
