package com.poly.hangnt169.B4_CRUDListFixCung.controller;
/**
 * @author hangnt169
 */

import com.poly.hangnt169.B4_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B4_CRUDListFixCung.service.SinhVienService;
import com.poly.hangnt169.B4_CRUDListFixCung.service.impl.SinhVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search",   // GET
        "/sinh-vien/detail", // GET
        "/sinh-vien/remove",// GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/update",  // POST
        "/sinh-vien/view-add", // GET
        "/sinh-vien/add" // POST
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> listSinhVien = new ArrayList<>();
    // Co 2 cach goi
    // Class = new Class
    // Inteface = new Class

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            // search du lieu
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            // Remove du lieu
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            // detail du lieu
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi form add
            this.viewAddSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            // hien thi form update
            this.viewUpdateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("add")) {
            // hien thi du lieu
            this.addSinhVien(request, response);
        } else if (uri.contains("update")) {
            // search du lieu
            this.updateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay toan bo du lieu tu form html
        String mssv = request.getParameter("mssv");
        String tenStr = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        String tuoi = request.getParameter("tuoi");

        // B2: Tao contructor /builder
//        SinhVien sv = SinhVien.builder()
//                .ten(tenStr)
//                .mssv(mssv)
//                .diaChi(diaChi)
//                .gioiTinh(Boolean.valueOf(gioiTinh))
//                .tuoi(Integer.valueOf(tuoi))
//                .build();
        SinhVien sv = new SinhVien(mssv,tenStr,Integer.valueOf(tuoi),diaChi,Boolean.valueOf(gioiTinh));
        // B3: Add vao list
        listSinhVien.add(sv);
        request.setAttribute("lists", listSinhVien);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tri tu view jsp ve servlet
        String index = request.getParameter("id");
        SinhVien sv = sinhVienService.getOne(listSinhVien,Integer.valueOf(index));
        request.setAttribute("sinhVien",sv);
        request.getRequestDispatcher("/buoi4/update-sinh-vien.jsp").forward(request,response);
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi4/add-sinh-vien.jsp").forward(request,response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tri tu view jsp ve servlet
        String index = request.getParameter("id");
        SinhVien sv = sinhVienService.getOne(listSinhVien,Integer.valueOf(index));
        request.setAttribute("sinhVien",sv);
        request.getRequestDispatcher("/buoi4/detail-sinh-vien.jsp").forward(request,response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay gia tri tu view jsp ve servlet
        String index = request.getParameter("id");
        sinhVienService.removeStudent(listSinhVien, Integer.valueOf(index));
        // C1:
//        if(listSinhVien.isEmpty()){
//            listSinhVien = sinhVienService.fakeData();
//        }
//        request.setAttribute("lists",listSinhVien);
//        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listSinhVien.isEmpty()) {
            listSinhVien = sinhVienService.fakeData();
        }
        request.setAttribute("lists", listSinhVien);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
    }
}
