package com.poly.hangnt169.B2_3_OverviewJavaWeb;
/**
 * @author hangnt169
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "XuLyFormController", value = {"/login","/ket-qua"})
public class XuLyFormController extends HttpServlet {
    // Controller là tầng trung gian trao đổi giữa client (view - giao diện) với server
    // thông qua phương thức http
    // Ở Java 4,5 chỉ làm việc với 2 phương thức : GET, POST
    // GET : Hiển thị
    // POST : Xử lý
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyền giá trị từ servlet sang jsp
        request.setAttribute("h1","Xin chao");
        // chuyển trang
        request.getRequestDispatcher("login.jsp").forward(request,response);
//        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy giá trị từ jsp về
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");

        // Truyền giá trị sang jsp mới
        request.setAttribute("t1",username);
        request.setAttribute("t2",password);

        // chuyen trang
        request.getRequestDispatcher("hien-thi.jsp").forward(request,response);
    }
}
