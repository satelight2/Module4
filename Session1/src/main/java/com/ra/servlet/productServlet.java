package com.ra.servlet;

import com.ra.entity.Product;
import com.ra.service.impl.ProductServiceImpl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productServlet", value = "/product")
public class productServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    List<Product> list = productService.findAll();
    public void init() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        System.out.println(action+"-------------------");
        if(action==null){
            getAllProduct(request, response);
        }
        if(action != null && action.equals("Update")){
            for (Product product : list) {
                if (product.getProductId().equals(request.getParameter("productId"))) {
                    System.out.println(product.getProductId() + "-------------------");
                    request.setAttribute("updateProduct", product);
                    request.getRequestDispatcher("/views/updateProduct.jsp").forward(request, response);
                    break;
                }
            }
        }else if(action != null && action.equals("Delete")){
            for (Product product : list) {
                if (product.getProductId().equals(request.getParameter("productId"))) {
                    list.remove(product);
                    break;
                }
            }
            request.setAttribute("listClone", list);
            request.getRequestDispatcher("/views/productList.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("Create")){
            String productId = req.getParameter("productID");
            String productName = req.getParameter("productName");
            String manufacturer = req.getParameter("manufacturer");
            String createdString = req.getParameter("created");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date createdDate = null;
            try {
                createdDate = formatter.parse(createdString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int batch = Integer.parseInt(req.getParameter("batch"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String productStatus = req.getParameter("productStatus");
            boolean productStatus1 ;
            boolean isChecked = "on".equals(productStatus); // Kiểm tra xem giá trị của trường trạng thái có phải là "on" không
            if (isChecked) {
                productStatus1 = true;
            } else {
                productStatus1 = false;
            }
            Product product = new Product(productId, productName, manufacturer, createdDate, batch, quantity, productStatus1);

            list.add(product);
        }else if(action != null && action.equals("Update")){
            String productId = req.getParameter("productID");
            String productName = req.getParameter("productName");
            String manufacturer = req.getParameter("manufacturer");
            String createdString = req.getParameter("created");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date createdDate = null;
            try {
                createdDate = formatter.parse(createdString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int batch = Integer.parseInt(req.getParameter("batch"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String productStatus = req.getParameter("productStatus");
            boolean productStatus1 ;
            boolean isChecked = "on".equals(productStatus); // Kiểm tra xem giá trị của trường trạng thái có phải là "on" không
            if (isChecked) {
                productStatus1 = true;
            } else {
                productStatus1 = false;
            }
            Product product = new Product(productId, productName, manufacturer, createdDate, batch, quantity, productStatus1);
            for (Product product1 : list) {
                if (product1.getProductId().equals(productId)) {
                    list.set(list.indexOf(product1), product);
                    break;
                }
            }
        }

        req.setAttribute("listClone", list);
        req.getRequestDispatcher("/views/productList.jsp").forward(req, resp);





    }

    public void destroy() {
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("listClone", list);
        request.getRequestDispatcher("/views/productList.jsp").forward(request, response);
    }
}
