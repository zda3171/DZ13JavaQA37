package ru.netology.repository;

import ru.netology.product.Product;

public class ProductManager {
    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }


    public void add(Product product) {                // Метод добавления продуктов в репозиторий

        repo.save(product);
    }


    public Product[] searchBy(String text) {                // Метод поиска продуктов по запросу
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.products) {
            if (matches(product, text)) {
                result = searchBy(text);
                result[result.length -1] = product; // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
        // или в одну строку:
        // return product.getName().contains(search);
    }


}
