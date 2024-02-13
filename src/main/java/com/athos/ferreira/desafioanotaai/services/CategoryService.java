package com.athos.ferreira.desafioanotaai.services;

import com.athos.ferreira.desafioanotaai.domain.category.Category;
import com.athos.ferreira.desafioanotaai.domain.category.exceptions.CategoryNotFound;
import com.athos.ferreira.desafioanotaai.domain.category.request.CategoryRequest;
import com.athos.ferreira.desafioanotaai.domain.category.request.UpdateCategoryRequest;
import com.athos.ferreira.desafioanotaai.domain.category.response.CategoryResponse;
import com.athos.ferreira.desafioanotaai.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse insert(CategoryRequest data){
        Category category = new Category(data);
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }


    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll().stream().map(CategoryResponse::new).toList();
    }


    public CategoryResponse update(String id, UpdateCategoryRequest data){
        Category category = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFound::new);
        if (!data.title().isEmpty()) category.setTitle(data.title());
        if (!data.description().isEmpty()) category.setDescription(data.description());

        return new CategoryResponse(category);

    }

    public void delete(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFound::new);
        categoryRepository.delete(category);
    }

    public CategoryResponse getById(String id) {
        return categoryRepository.findById(id).map(CategoryResponse::new)
                .orElseThrow(CategoryNotFound::new);
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(CategoryNotFound::new);
    }
}
