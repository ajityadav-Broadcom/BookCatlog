package com.Ajit.Modal;

import java.util.UUID;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private int yearOfPublish;
    private int cost;
    private int soldCopies;
    private String category;
    private String id;

    public Book(String author, String title, String publisher, int yearOfPublish, int cost, int soldCopies, String category) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.cost = cost;
        this.soldCopies = soldCopies;
        this.category = category;
        this.id = UUID.randomUUID().toString();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getCost() {
        return cost;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }
}
