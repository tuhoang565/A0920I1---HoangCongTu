package com.demo.model;

public class ShoppingCart {
    private int quantityOrder;
    private Book book;

    public ShoppingCart() {
    }

    public ShoppingCart(int quantityOrder, Book book) {
        this.quantityOrder = quantityOrder;
        this.book = book;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
