package com.athos.ferreira.desafioanotaai.domain.category;

import com.athos.ferreira.desafioanotaai.domain.category.request.CategoryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categoryies")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryRequest category) {
        this.title = category.title();
        this.description = category.description();
        this.ownerId = category.ownerId();
    }
}
