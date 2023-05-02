package com.example.graphql.service;

import com.example.graphql.entity.Book;

import java.util.List;

public interface BookService {

    //create Book
    Book createBook(Book book);

    //get book

    List<Book>getAllBook();

    //get book by id

    Book getBookById(int id);
}
