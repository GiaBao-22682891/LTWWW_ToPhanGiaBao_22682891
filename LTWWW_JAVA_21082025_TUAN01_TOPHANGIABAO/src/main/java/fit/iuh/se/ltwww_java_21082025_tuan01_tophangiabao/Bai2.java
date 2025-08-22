package fit.iuh.se.ltwww_java_21082025_tuan01_tophangiabao;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "bai2", urlPatterns = "/bai-2")
public class Bai2 extends HttpServlet{
    private String message;
    private String message2;
    private String nextPage3;
    private String nextPage4;
    private String nextPage5;

    public void init () {
        message = "This is Exercise 2!";
        message2 = "This exercise basically shows us how to interact with doGet()";
        nextPage3 = "Click here for Exercise 3: doGet() with Json -->";
        nextPage4 = "Click here for Exercise 4: init-param and context-param -->";
        nextPage5 = "Click here for Exercise 5: a login form -->";

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1 style='color: red'>" + message + "</h1>");
        out.println("<div>" + message2 + "</div>");
        out.println("<div>" + "Now let's try other exercises with some new lessons" + "</div>");
        out.println("<br/>");
        out.println("<a href='bai-3'>" + nextPage3 + "</a>");
        out.println("</body></html>");
        out.println("<br/>");
        out.println("<a href='bai-4'>" + nextPage4 + "</a>");
        out.println("</body></html>");
        out.println("<br/>");
        out.println("<a href='login.html'>" + nextPage5 + "</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
