package iuh.fit.se.ltwww_java_28082025_tuan02_tophangiabao;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String username;

    public void init() {
        message = "Hello ";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = req.getParameter("usernameHTML");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + username + "!" + "</h1><br>");
        out.println("<h2>" + "Welcome back! Let's begin our journey again" + "</h2><br>");
        out.println("<a href='file-uploader.html'>" + "Exercise 2: Multi-files upload"  +"</a><br>");
        out.println("<a href='upload-to-database.html'>" + "Exercise 3: Upload file to Database"  +"</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}