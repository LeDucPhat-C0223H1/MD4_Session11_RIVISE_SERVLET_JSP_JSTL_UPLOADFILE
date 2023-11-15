package ra.practicejsp_jstl_15112023.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024, //5MB
        maxRequestSize = 15 * 1024 *1024, //25MB
        fileSizeThreshold = 1024 * 1024 // 1MB
)

@WebServlet(name = "UploadFile", value = "/UploadFile")
public class UploadFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action!=null && action.equals("UPLOAD")){
            // lấy ra đường dẫn muốn upload đến
            String uploadPath = getServletContext().getRealPath("/uploads");
            // kiểm tra cái file tồn tại hay chưa, file bao gồm cả tệp và thư mục
            File file = new File(uploadPath);
            if(!file.exists()){
                // chưa tồn tại thì tạo 1 thư mục
                file.mkdirs();
            }

            List<String> listFileNames = new ArrayList<>();
            // lấy ra danh sách file upload
            Collection<Part> listFile = request.getParts();

            for (Part part: listFile) {
                if(part.getName().equals("image")){
                    // upload image
                    String nameFile = part.getSubmittedFileName();
                    part.write(uploadPath + File.separator + nameFile);
                    listFileNames.add(nameFile);
                } else if(part.getName().equals("avatar")){
                        // upload avatar
                        String nameFile = part.getSubmittedFileName();
                        part.write(uploadPath + File.separator + nameFile);
                    listFileNames.add(nameFile);
                }
            }

            // truyền đường dẫn ảnh sang view
            request.setAttribute("action","uploadFile");
            request.setAttribute("listFileNames", listFileNames);
            request.getRequestDispatcher("WEB-INF/views/about-us.jsp").forward(request,response);
        }
    }
}
 
