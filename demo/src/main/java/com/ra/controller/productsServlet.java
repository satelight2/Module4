package com.ra.controller;

import com.ra.entity.Product;
import com.ra.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductsServlet", value = "/products")
public class productsServlet extends Controller{
    ProductServiceImpl productService = new ProductServiceImpl();
    List<Product> list = productService.findAll();
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("listClone", list);
        request.getRequestDispatcher("/views/productList.jsp").forward(request, response);
    }
    public void createPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        req.getRequestDispatcher("/views/addProduct.jsp").forward(req, response);

        Product product = getProduct(req, response);
        list.add(product);
        req.setAttribute("listClone", list);
        req.getRequestDispatcher("/views/productList.jsp").forward(req, response);
    }
    public void UpdateGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        for (Product product : list) {
            if (product.getProductId().equals(req.getParameter("productId"))) {
                req.setAttribute("updateProduct", product);
                req.getRequestDispatcher("/views/updateProduct.jsp").forward(req, response);
                break;
            }
        }

    }
    public void UpdatePost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        Product product = getProduct(req, response);
        for (Product product1 : list) {
            if (product1.getProductId().equals(req.getParameter("productID"))) {
                list.set(list.indexOf(product1), product);
                break;
            }
        }
        req.setAttribute("listClone", list);
        req.getRequestDispatcher("/views/productList.jsp").forward(req, response);
    }
    public void Search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/findedProduct.jsp").forward(request, response);
    }
    public void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        for (Product product : list) {
            if (product.getProductId().equals(request.getParameter("productId"))) {
                list.remove(product);
                break;
            }
        }
        request.setAttribute("listClone", list);
        request.getRequestDispatcher("/views/productList.jsp").forward(request, response);
    }
    public Product getProduct(HttpServletRequest req, HttpServletResponse response) {
        String productId = req.getParameter("productID");
        String productName = req.getParameter("productName");
        String manufacturer = req.getParameter("manufacturer");
        String createdString = req.getParameter("created");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
        return product;
    }
}
