/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ahmudz.librarymanagementsystem;

/**
 *
 * @author Mahmud
 */
public class Book {
    int id;
    String name;
    String author;
    int stock;

    public Book(int id, String name, String author, int stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
}
