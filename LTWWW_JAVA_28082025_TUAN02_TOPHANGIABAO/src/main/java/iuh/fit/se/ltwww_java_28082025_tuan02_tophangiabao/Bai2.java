package iuh.fit.se.ltwww_java_28082025_tuan02_tophangiabao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet (urlPatterns = "/upload")
@MultipartConfig (
        fileSizeThreshold = 1024 * 1024 * 1, //1MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 25 //25MB
)

public class Bai2 extends HttpServlet {
    private String uploadPath = "/uploads_folder_Server";
    private String uploadPathToSource;
    private String uploadPathToTarget;

    @Override
    public void init() throws ServletException {
        //1. Source Path
        String userDir = System.getProperty("user.dir");
        if (userDir.contains("tomcat") && userDir.endsWith("bin")) {
            userDir = new File(userDir).getParent();
            userDir = new File(userDir).getParent();
        }

        uploadPathToSource = userDir + "/LTWWW_JAVA_28082025_TUAN02_TOPHANGIABAO/src/main/webapp/uploads_folder_Server";
        File uploadPathToSourceDir = new File(uploadPathToSource);
        if (!uploadPathToSourceDir.exists()) {
            uploadPathToSourceDir.mkdirs();
        }

        //2. Target Path
        uploadPathToTarget = this.getServletContext().getRealPath("/uploads_folder_Server");
        File uploadPathToTargetDir = new File(uploadPathToTarget);
        if (!uploadPathToTargetDir.exists()) {
            uploadPathToTargetDir.mkdirs();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part filePart : req.getParts()) {
            if (filePart == null || filePart.getSubmittedFileName() == null || filePart.getSubmittedFileName().isEmpty()) {
                continue;
            }

            String fileName = filePart.getSubmittedFileName();

            //Save file to the server
            InputStream inputStream = filePart.getInputStream();
            Files.copy(inputStream, Paths.get(uploadPathToSource + File.separator + fileName),
                    StandardCopyOption.REPLACE_EXISTING);

            Files.copy(inputStream, Paths.get(uploadPathToTarget + File.separator + fileName),
                    StandardCopyOption.REPLACE_EXISTING);

//Because returns a stream can only be read once, the first copy would be succeeded while the second one is null
//Need to write like this :
//            try (InputStream inputStream1 = filePart.getInputStream()) {
//                Files.copy(inputStream1, Paths.get(uploadPathToSource, fileName), StandardCopyOption.REPLACE_EXISTING);
//            }
//
//            try (InputStream inputStream2 = filePart.getInputStream()) {
//                Files.copy(inputStream2, Paths.get(uploadPathToTarget, fileName), StandardCopyOption.REPLACE_EXISTING);
//            }
            PrintWriter out = resp.getWriter();
            out.println("<h1>" + "Your files have successfully uploaded, go check it!" + "</h1><br>");
            out.println("<a href='hello-servlet'>" + "Click here to return to home page" + "</a>");
            System.out.println(uploadPath + File.separator + fileName);
        }

    }


}
