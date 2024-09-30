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

    public UserServlet() {
        listUser.add(new User("U1", "Nguyen Van", 20, "Ha Noi", "Doc than"));
        listUser.add(new User("U2", "Nguyen Van", 20, "Ha Noi", "Doc than"));
        listUser.add(new User("U3", "Nguyen Van", 20, "Ha Noi", "Doc than"));
    }

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
            String name = "Nguyen Van A";
            request.setAttribute("user", user);
            request.setAttribute("hoTen", name);
            request.setAttribute("listUser", listUser);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (uri.contains("/user/detail")) {
            String id = request.getParameter("id");
            User userDetail = new User();
            for (User u : listUser) {
                if (u.getId().equals(id)) {
                    userDetail = u;
                }
            }
            request.setAttribute("userDetail", userDetail);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/user/delete")) {
            String id = request.getParameter("id");
            User userDetail = new User();
            for (User u : listUser) {
                if (u.getId().equals(id)) {
                    userDetail = u;
                }
            }
            listUser.remove(userDetail);
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
            listUser.add(user);
            response.sendRedirect("/UserServlet");
        } else if (uri.contains("/user/update")) {
            String id = request.getParameter("id");
            System.out.println("id : " + id);
            for (User u : listUser) {
                if (u.getId().contains(id)) {
                    u.setAge(Integer.parseInt(request.getParameter("age")));
                    u.setName(request.getParameter("name"));
                    u.setAddress(request.getParameter("address"));
                    u.setStatus(request.getParameter("status"));
                }
            }
            response.sendRedirect("/UserServlet");
        }
    }
}
