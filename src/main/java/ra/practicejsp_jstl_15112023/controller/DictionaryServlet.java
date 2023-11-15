package ra.practicejsp_jstl_15112023.controller;

import ra.practicejsp_jstl_15112023.model.Word;
import ra.practicejsp_jstl_15112023.service.IDictionaryService;
import ra.practicejsp_jstl_15112023.serviceImpl.DictionaryService;

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

@WebServlet(name = "Dictionary", value = "/Dictionary")
public class DictionaryServlet extends HttpServlet {
    private IDictionaryService dictionaryService = new DictionaryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if(action!=null && action.equals("ADD")){
            // lấy ra đường dẫn muốn upload đến
            String uploadPath = getServletContext().getRealPath("/uploads");
            // kiểm tra cái file tồn tại hay chưa, file bao gồm cả tệp và thư mục
            File file = new File(uploadPath);
            if(!file.exists()){
                file.mkdirs();
            }
            Part part = request.getPart("image");
            String imageUrl = part.getSubmittedFileName();
            part.write(uploadPath + File.separator + imageUrl);

            String name = request.getParameter("name");

            dictionaryService.save(new Word(name, imageUrl));
        }
        display(request, response, dictionaryService.findAll());
    }

    private static void display(HttpServletRequest request, HttpServletResponse response, List<Word> dictionary) throws ServletException, IOException {
        request.setAttribute("action","display");
        request.setAttribute("dictionary", dictionary);
        request.getRequestDispatcher("WEB-INF/views/list-product.jsp").forward(request, response);
    }
}
 
