package iuh.fit.se.ltwww_java_28082025_tuan02_tophangiabao;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet (urlPatterns = "/upload")
@MultipartConfig (
        location = "/tmp",
        fileSizeThreshold = 1024 * 1024 * 1, //1MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 25 //25MB
)

public class Bai2 extends HttpServlet {
    
}
