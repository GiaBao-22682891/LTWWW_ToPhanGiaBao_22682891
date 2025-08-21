package fit.iuh.se.ltwww_java_21082025_tuan01_tophangiabao;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import fit.iuh.se.ltwww_java_21082025_tuan01_tophangiabao.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "bai3", urlPatterns = "/bai-3")
public class Bai3 extends HttpServlet{
    private String message;
    private User user;

    public void init () {
        message = "This is Exercise 3!";
        user = new User("X001", "Player1", "Player01@gmail.com");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        resp.getWriter().write(json);

    }

    public void destroy() {
    }
}
