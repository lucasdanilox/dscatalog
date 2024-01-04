package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long existsId;
    private long nonExistendId;
    private long countTotalProducts = 25L;

    @BeforeEach
    void setUp() throws Exception {
        existsId = 1L;
        nonExistendId = -1L;

    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existsId);

        Optional<Product> result = repository.findById(existsId);
        Assertions.assertFalse(result.isPresent());

    }

    @Test
    public void repositoryShouldObjectWhenIdExists() {

        Optional<Product> result = repository.findById(existsId);

        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void repositoryShouldObjectWhenIdNoExists() {

        Optional<Product> result = repository.findById(nonExistendId);

        Assertions.assertTrue(result.isEmpty());

    }
}
