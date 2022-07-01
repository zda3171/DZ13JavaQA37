package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Product;

public class ProductRepocitoryTest {
    Product product1 = new Product(12,"Vesna", 120 );
    Product product2 = new Product(22,"Leto", 220 );
    Product product3 = new Product(32,"Zima", 320 );
    Product product4 = new Product(42,"Vesna", 420 );


    @Test
    public void saveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.products();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void delItemIdProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.deleteById(product3.getId());

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.products();

        Assertions.assertArrayEquals(expected, actual);
    }
}
