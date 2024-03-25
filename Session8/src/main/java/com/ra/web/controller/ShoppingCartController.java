package com.ra.web.controller;

import com.ra.web.entity.ProductsEntity;
import com.ra.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ShoppingCartController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<ProductsEntity> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        return "productList";
    }

    @GetMapping("/cart")
    public String showCart(Model model, HttpSession session) {
        List<ProductsEntity> cartItems = (List<ProductsEntity>) session.getAttribute("cartItems");
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable int productId, @RequestParam("quantity") int quantity, HttpSession session) {
        ProductsEntity product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            List<ProductsEntity> cartItems = (List<ProductsEntity>) session.getAttribute("cartItems");
            if (cartItems == null) {
                cartItems = new ArrayList<>();
                session.setAttribute("cartItems", cartItems);
            }

            // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
            boolean existingProduct = false;
            // Nếu sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng
            for (ProductsEntity item : cartItems) {
                if (item.getProductId() == productId) {
                    item.setStockQuantity(item.getStockQuantity() + quantity);
                    existingProduct = true;
                    break;
                }
            }

            // Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm mới vào giỏ hàng
            if (!existingProduct) {
                ProductsEntity cartItem = new ProductsEntity();
                cartItem.setProductId(product.getProductId());
                cartItem.setName(product.getName());
                cartItem.setPrice(product.getPrice());
                cartItem.setStockQuantity(quantity);
                cartItems.add(cartItem);
            }


            session.setAttribute("cartItems", cartItems);
        }
        return "redirect:/cart";
    }
}
