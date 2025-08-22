package fit.iuh.se.ltwww_java_21082025_tuan01_tophangiabao;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet (name = "loginServlet", urlPatterns = "/login")
public class loginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>" + "<body>");
        out.println("<h1>" + "Register Form" + "</h1>");
        out.println("</html>" + "</body>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String bio = req.getParameter("bio");


        out.println("<html>" + "<body>");
        out.println("<h1 style='color:pink'>" + "Hello " + name + ", welcome to our page!" + "</h1>");

        out.println("<br>"+ "<h2>" + "This is your personal information" + "</h2>");
        out.println("<table>");
        out.println("<tr>" + "<td>" + "<b>Name: </b>" + "</td>" + "<td>" + name + "</td>" + "<br>");
        out.println("<tr>" + "<td>" + "<b>Username: </b>" + "</td>" + "<td>" + username + "</td>" + "<br>");
        out.println("<tr>" + "<td>" + "<b>Email: </b>" + "</td>" + "<td>" + email + "</td>" + "<br>");
        out.println("<tr>" + "<td>" + "<b>Bio: </b>" + "</td>" + "<td>" + bio + "</td>" + "<br>");
        out.println("</table>");
        out.println("</body>" + "</html>");


    }
}
