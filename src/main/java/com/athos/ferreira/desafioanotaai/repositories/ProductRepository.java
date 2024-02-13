package com.athos.ferreira.desafioanotaai.repositories;

import com.athos.ferreira.desafioanotaai.domain.products.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
