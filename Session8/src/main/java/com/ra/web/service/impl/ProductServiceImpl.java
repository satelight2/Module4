package com.ra.web.service.impl;

import com.ra.web.entity.ProductsEntity;
import com.ra.web.repository.ProductRepository;
import com.ra.web.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsEntity> findAll() {
        return productRepository.findAll();
    }


}
