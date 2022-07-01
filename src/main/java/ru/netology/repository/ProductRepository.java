package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {

    protected Product[] products = new Product[0];      // Поле массива с товарами (продуктами)


    public void save(Product product) {                    // Метод сохранения добовляемых Продуктов
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public Product[] products() {            // Метод получения всех сохраненных продуктов

        return products;
    }


    public void deleteById(int id) {            // Метод удаления сохраненных продуктов по id
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
