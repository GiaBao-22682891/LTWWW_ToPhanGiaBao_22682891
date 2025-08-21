package fit.iuh.se.ltwww_java_21082025_tuan01_tophangiabao;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Cach 2:
//@WebServlet (name = "bai4",
//        urlPatterns = {"/bai-4", "/bai-4-servlet"},
//        initParams = {
//                @WebInitParam(name = "username", value = "Player2"),
//                @WebInitParam(name = "email", value = "Player2@gmail.com")
//        }
//
//)
public class Bai4 extends HttpServlet {
    private String message;
    private String username;
    private String email;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message = "This is Exercise 4";
//        username = config.getInitParameter("username");
        email = config.getInitParameter("email"); //Dùng chung thì khai báo đây

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>" + "<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2 style='color: red'>" + "Username: " + this.getServletConfig().getInitParameter("username") + "</h2>");
        out.println("<h2 style='color: blue'>" + "Email: " + email + "</h2>");
        out.println("<h2 style='color: green'>" + this.getServletContext().getInitParameter("appName") + "</h2>");
        out.println("</body>" + "</html>");

    }
}
