package com.example.graphql.service.impl;

import com.example.graphql.entity.Book;
import com.example.graphql.repository.BookRepo;
import com.example.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImple implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book createBook(Book book) {

        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return this.bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book is not available with the specific id "));

    }
}
