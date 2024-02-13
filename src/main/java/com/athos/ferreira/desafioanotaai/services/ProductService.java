package com.athos.ferreira.desafioanotaai.services;

import com.athos.ferreira.desafioanotaai.domain.category.Category;

import com.athos.ferreira.desafioanotaai.domain.products.Product;
import com.athos.ferreira.desafioanotaai.domain.products.exceptions.ProductNotFound;
import com.athos.ferreira.desafioanotaai.domain.products.request.ProductRequest;
import com.athos.ferreira.desafioanotaai.domain.products.request.UpdateProductRequest;
import com.athos.ferreira.desafioanotaai.domain.products.response.ProductResponse;
import com.athos.ferreira.desafioanotaai.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse insert(ProductRequest data) {
        Category category = categoryService.getCategoryById(data.categoryId());
        Product product = new Product(data);
        product.setCategory(category);
        productRepository.save(product);
        return new ProductResponse(product);
    }


    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream().map(ProductResponse::new).toList();
    }

    public ProductResponse getById(String id) {
        return productRepository.findById(id).map(ProductResponse::new)
                .orElseThrow(() -> new RuntimeException("Category not found")); //TODO: Create a custom exception
    }

    public ProductResponse update(String id, UpdateProductRequest data) {

        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFound::new);

        if (data.categoryId() != null) {
            Category category = categoryService.getCategoryById(data.categoryId());
            product.setCategory(category);
        }

        if (!data.title().isEmpty()) product.setTitle(data.title());
        if (!data.description().isEmpty()) product.setDescription(data.description());
        if (data.price() != null) product.setPrice(data.price());

        return new ProductResponse(product);

    }

    public void delete(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFound::new);
        productRepository.delete(product);
    }

}
