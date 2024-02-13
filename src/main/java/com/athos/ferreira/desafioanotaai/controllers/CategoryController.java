package com.athos.ferreira.desafioanotaai.controllers;

import com.athos.ferreira.desafioanotaai.domain.category.Category;
import com.athos.ferreira.desafioanotaai.domain.category.request.CategoryRequest;
import com.athos.ferreira.desafioanotaai.domain.category.request.UpdateCategoryRequest;
import com.athos.ferreira.desafioanotaai.domain.category.response.CategoryResponse;
import com.athos.ferreira.desafioanotaai.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> insert(@RequestBody CategoryRequest data){
        CategoryResponse categoryInserted = categoryService.insert(data);
        return ResponseEntity.ok(categoryInserted);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
           List<CategoryResponse> categories = categoryService.getAll();
            return ResponseEntity.ok(categories);

    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getAll(@PathVariable String id){
        CategoryResponse category = categoryService.getById(id);
        return ResponseEntity.ok(category);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoryResponse> update(@PathVariable String id, @RequestBody UpdateCategoryRequest data){
        CategoryResponse category = categoryService.update(id, data);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
