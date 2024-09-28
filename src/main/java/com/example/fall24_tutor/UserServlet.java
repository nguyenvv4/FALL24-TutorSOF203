package com.example.fall24_tutor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", value = {"/UserServlet",
        "/user/add",
        "/user/detail",
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");
    }
}
