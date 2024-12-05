/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ahmudz.librarymanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * ahmudz
 */
public class BookManager {

    static Optional<Book> searchByName(String name) {
        DatabaseConnection conn = new DatabaseConnection();

        return Optional.empty();
    }

    static List<Book> getBooks() {

        List<Book> books = new ArrayList<>();

        try {
            DatabaseConnection conn = new DatabaseConnection();

            ResultSet res = conn.executeQuery("SELECT * FROM books");

            while (res.next()) {

                books.add(
                        new Book(
                                Integer.parseInt(res.getString("id")),
                                res.getString("name"),
                                res.getString("author"),
                                Integer.parseInt(res.getString("stock"))
                        )
                );
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return books;
    }

    static void addBook(String name, String author, String stock) {
        try {

            DatabaseConnection conn = new DatabaseConnection();

            conn.execute("insert into books (name, author, stock)values ('" + name + "', '" + author + "', '" + stock + "')");

        } catch (Exception e) {
            System.out.println("ERROR: Failed to add book: " + e.getMessage());
        }
    }

    static void updateBook(String id, String name, String author, String stock) throws SQLException {
        // TODO: Update book in database
        DatabaseConnection con = new DatabaseConnection();
        con.executeUpdate("UPDATE books SET NAME = ?, author = ?, stock = ? WHERE id = ?", name, author, stock, id);

    }

    static void reduceStock(String name, int amount) {

    }

}
