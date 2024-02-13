package com.athos.ferreira.desafioanotaai.domain.category.response;

import com.athos.ferreira.desafioanotaai.domain.category.Category;

public record CategoryResponse(String title, String description, String ownerId){
    public CategoryResponse(Category categoryInserted) {
        this(categoryInserted.getTitle(), categoryInserted.getDescription(), categoryInserted.getOwnerId());
    }
}
