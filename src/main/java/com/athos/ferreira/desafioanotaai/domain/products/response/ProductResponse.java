package com.athos.ferreira.desafioanotaai.domain.products.response;

import com.athos.ferreira.desafioanotaai.domain.category.Category;
import com.athos.ferreira.desafioanotaai.domain.products.Product;

public record ProductResponse(
        String title,
        String description,
        String ownerId,
        Integer price,
        Category category
) {
    public ProductResponse(Product product) {
        this(product.getTitle(), product.getDescription(), product.getOwnerId(), product.getPrice(), product.getCategory());
    }
}
