package com.ra.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/trang-chu")
public class homeServlet extends HttpServlet {


    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = "satelight2@gmail.com";
        boolean gender = true;
        List<String> list = Arrays.asList("Java", "Python", "C++", "C#");


        request.setAttribute("email", email);
        request.setAttribute("gender",gender);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
