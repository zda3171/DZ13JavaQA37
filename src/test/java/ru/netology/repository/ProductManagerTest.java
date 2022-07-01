package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.product.Product;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(12, "Vesna", 120);
    Product product2 = new Product(22, "Leto", 220);
    Product product3 = new Product(32, "Zima", 320);
    Product product4 = new Product(42, "Vesna", 420);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }




    @Test
    public void shouldAddProduct() {

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = manager.repo.products();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {

        manager.searchBy("Zima");

        Product[] expected = { product3 };
        Product[] actual = manager.repo.products();

        Assertions.assertArrayEquals(expected, actual);


    }
}
