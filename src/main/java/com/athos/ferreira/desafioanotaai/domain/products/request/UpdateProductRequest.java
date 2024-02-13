package com.athos.ferreira.desafioanotaai.domain.products.request;

public record UpdateProductRequest(
        String title,
        String description,
        Integer price,
        String categoryId
) {
}
