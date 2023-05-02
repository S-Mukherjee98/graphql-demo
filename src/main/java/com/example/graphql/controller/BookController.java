package com.example.graphql.controller;

import com.example.graphql.entity.Book;
import com.example.graphql.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book createBook(@Argument BookInput book){

        Book b= new Book();
        b.setName(book.getName());
        b.setAbout(book.getAbout());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        System.out.println("This Is The Object: "+book);
        return bookService.createBook(b);
    }

   @QueryMapping("allBooks")

    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @QueryMapping("getBook")
    Book getBookById(@Argument int bookId){
        return bookService.getBookById(bookId);
    }
}

@Getter
@Setter
class BookInput{
    private String name;
    private String about;
    private String author;
    private int price;
}
