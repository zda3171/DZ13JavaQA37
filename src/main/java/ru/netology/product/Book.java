package ru.netology.product;

import ru.netology.product.Product;

public class Book extends Product {

    private String author;


    public Book(int id, String nane, int price, String author) {
        super(id, nane, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
