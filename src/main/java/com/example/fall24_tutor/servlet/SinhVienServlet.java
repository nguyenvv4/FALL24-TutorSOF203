package com.example.fall24_tutor.servlet;

import com.example.fall24_tutor.entity.LopHoc;
import com.example.fall24_tutor.entity.SinhVien;
import com.example.fall24_tutor.repository.LopHocRepo;
import com.example.fall24_tutor.repository.SinhVienRepo;
import com.example.fall24_tutor.service.SInhVienServiceImpl;
import com.example.fall24_tutor.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/add",
        "/sinh-vien/detail",
        "/sinh-vien/delete",
})
public class SinhVienServlet extends HttpServlet {

    SinhVienService sinhVienService = new SInhVienServiceImpl();

    LopHocRepo lopHocRepo = new LopHocRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sinh-vien/hien-thi")) {
            ArrayList<SinhVien> list = sinhVienService.getList();
            ArrayList<LopHoc> listLopHoc = lopHocRepo.getList();
            request.setAttribute("listSinhVien", list);
            request.setAttribute("listLopHoc", listLopHoc);
            request.getRequestDispatcher("/sinh-vien.jsp").forward(request, response);
        } else if (uri.contains("/sinh-vien/delete")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            sinhVienService.delete(id);
            response.sendRedirect("/sinh-vien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
