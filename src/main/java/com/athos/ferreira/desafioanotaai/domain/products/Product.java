package com.athos.ferreira.desafioanotaai.domain.products;

import com.athos.ferreira.desafioanotaai.domain.category.Category;
import com.athos.ferreira.desafioanotaai.domain.products.request.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;

    public Product(ProductRequest data) {
        this.title = data.title();
        this.description = data.description();
        this.ownerId = data.ownerId();
        this.price = data.price();

    }
}
