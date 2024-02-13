package com.athos.ferreira.desafioanotaai.domain.products.request;

import com.athos.ferreira.desafioanotaai.domain.category.Category;

public record ProductRequest(
        String title,
        String description,
        String ownerId,
        Integer price,
        String categoryId
        ) {
}
