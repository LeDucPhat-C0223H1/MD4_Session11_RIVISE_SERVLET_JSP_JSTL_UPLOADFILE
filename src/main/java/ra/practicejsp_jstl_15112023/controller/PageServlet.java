package ra.practicejsp_jstl_15112023.controller;

import ra.practicejsp_jstl_15112023.model.Newspaper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PageServlet", value = "/PageServlet")
public class PageServlet extends HttpServlet {
    public List<Newspaper> createListNewspaper(){
        List<Newspaper> list = new ArrayList<>();
        Newspaper n1 = new Newspaper(
                "https://icdn.24h.com.vn/upload/4-2023/images/2023-11-15/Mua-dac-biet-lon-tai-Thua-Thien---Hue-lu-tren-song-Huong-vuot-dinh-nam-2020-lut-hue-1700020542-439-width740height555.jpg",
                "Mưa đặc biệt lớn tại Thừa Thiên - Huế, lũ trên sông Hương vượt đỉnh năm 2020",
                "Theo Trung tâm Dự báo khí tượng thủy văn Quốc gia, do ảnh hưởng của không khí lạnh, từ " +
                        "tối qua đến sáng nay (19h ngày 14/11-7h ngày 15/11), tỉnh Quảng Trị và các tỉnh, thành " +
                        "phố từ Đà Nẵng đến Khánh Hoà có mưa to đến rất to, lượng mưa phổ biến từ 30-70mm.",
                "Theo Bảng Anh (Nông thôn Việt)");
        Newspaper n2 = new Newspaper(
                "https://icdn.24h.com.vn/upload/4-2023/images/2023-11-14//1699966448-ong-cao-tuong-huy-duoc-gioi-thieu-lam-chu-tich-ubnd-tinh-quang-ninh-2144-5198-width850height566.jpeg",
                "Ông Cao Tường Huy được giới thiệu để bầu làm Chủ tịch UBND tỉnh Quảng Ninh",
                "Quyền Chủ tịch UBND tỉnh Quảng Ninh Cao Tường Huy được giới thiệu để kiện toàn chức " +
                        "danh Phó Bí thư Tỉnh ủy nhiệm kỳ 2020-2025, Chủ tịch UBND tỉnh Quảng Ninh nhiệm kỳ " +
                        "2021-2026.",
                "Theo NGỌC SƠN (Pháp luật TPHCM)");
        Newspaper n3 = new Newspaper(
                "https://icdn.24h.com.vn/upload/2-2023/images/2023-06-28/1-1687938161-992-width1920height1080.jpg",
                "Đề xuất thu phí cao tốc Vành đai 4 – Vùng Thủ đô 1.900 đồng/km, 3 năm tăng 1 lần",
                "Hà Nội vừa đề xuất thu phí dịch vụ đường cao tốc Vành đai 4 là 1.900 đồng/xe/km " +
                        "khi khai thác đưa vào sử dụng. Lộ trình giá dịch vụ đường cao tốc được điều chỉnh " +
                        "tăng 3 năm/lần cho đến thời điểm hoàn vốn.",
                "Theo Lê Bảo (Sức khỏe đời sống)");

        list.add(n1);
        list.add(n2);
        list.add(n3);
        return list;
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "HOME":
                List<Newspaper> list = createListNewspaper();
                request.setAttribute("action","home");
                request.setAttribute("list", list);
                request.getRequestDispatcher("/").forward(request,response);
                break;
            case "PRODUCT":
                request.setAttribute("action","product");
                request.getRequestDispatcher("WEB-INF/views/list-product.jsp").forward(request,response);
                break;
            case "ABOUT_US":
                request.setAttribute("action","about");
                request.getRequestDispatcher("WEB-INF/views/about-us.jsp").forward(request,response);
                break;
            case "PROFILE":
                request.setAttribute("action","profile");
                request.getRequestDispatcher("WEB-INF/views/profile.jsp").forward(request,response);
                break;
            case "CART":
                request.setAttribute("action","cart");
                request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request,response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
 
