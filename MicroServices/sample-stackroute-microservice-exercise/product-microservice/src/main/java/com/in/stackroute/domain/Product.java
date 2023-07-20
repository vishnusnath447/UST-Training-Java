package com.in.stackroute.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {
    @Id
    private int productId;
    private String name;
    public Product(){}

    public Product(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
