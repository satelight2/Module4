package com.ra.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "Controller", value = "/productsservlet")
public class Controller extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            forward(request, response);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            forward(request, response);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException {
        String action = request.getParameter("action");
        Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
try {
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
