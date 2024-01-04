package com.devsuperior.dscatalog.tests;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Factory {

    public static Product createProduct() {
        Set<Category> categories = new HashSet<>();
        categories.add(new Category(2L, "Eletronics"));
        return new Product(1L, "Phone", "Good Phone", 800.0, "https://img.com/img.png", Instant.parse("2024-01-20T03:00:00Z"), categories);
    }

    public static ProductDTO createProductDTO() {
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }
}
