package com.athos.ferreira.desafioanotaai.controllers;
import com.athos.ferreira.desafioanotaai.domain.products.request.ProductRequest;
import com.athos.ferreira.desafioanotaai.domain.products.request.UpdateProductRequest;
import com.athos.ferreira.desafioanotaai.domain.products.response.ProductResponse;
import com.athos.ferreira.desafioanotaai.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> insert(@RequestBody ProductRequest data){
        ProductResponse categoryInserted = productService.insert(data);
        return ResponseEntity.ok(categoryInserted);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductResponse> categories = productService.getAll();
        return ResponseEntity.ok(categories);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getAll(@PathVariable String id){
        ProductResponse category = productService.getById(id);
        return ResponseEntity.ok(category);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductResponse> update(@PathVariable String id, @RequestBody UpdateProductRequest data){
        ProductResponse category = productService.update(id, data);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
