package com.example.fall24_tutor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", value = {"/UserServlet",
        "/user/add",
        "/user/detail",
        "/user/delete",
        "/user/update"
})
public class UserServlet extends HttpServlet {

    ArrayList<User> listUser = new ArrayList<>();

    UserRepository userRepository = new UserRepository();



    /*
    Tao model khachhang(id, name. age, male, status, rank)
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //lay thong tin uri
        User user = new User("U1", "Nguyen Van", 20, "Ha Noi", "Doc than");
        // hien thi thong tin user len giao dien
        String uri = request.getRequestURI();
        if (uri.contains("/UserServlet")) {
            listUser = userRepository.getList();
            request.setAttribute("listUser", listUser);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (uri.contains("/user/detail")) {
            String id = request.getParameter("id");
            User  userDetail = userRepository.detail(id);
            request.setAttribute("userDetail", userDetail);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/user/delete")) {
            String id = request.getParameter("id");
            userRepository.delete(id);
            response.sendRedirect("/UserServlet");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/user/add")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            Integer age = Integer.parseInt(request.getParameter("age"));
            String status = request.getParameter("status");
            User user = new User(id, name, age, address, status);
            userRepository.addNew(user);
            response.sendRedirect("/UserServlet");
        } else if (uri.contains("/user/update")) {
            String id = request.getParameter("id");
            User userDetail = userRepository.detail(id);
            if (userDetail != null) {
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                Integer age = Integer.parseInt(request.getParameter("age"));
                String status = request.getParameter("status");
                User user = new User(id, name, age, address, status);
                userRepository.update(user);
                response.sendRedirect("/UserServlet");
            }
        }
    }
}
// nhap vao name => tim kiem theo name
// Tạo đối tượng
// San pham: id, name, price, quantity, category(select option): status

