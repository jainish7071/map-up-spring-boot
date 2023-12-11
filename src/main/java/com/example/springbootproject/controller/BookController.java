package com.example.springbootproject.controller;

import com.example.springbootproject.entity.BookEntity;
import com.example.springbootproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/book")
    public List<BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private BookEntity getBooksById(@PathVariable("bookid")int bookid){
        return bookService.getBookById(bookid);
    }
    @DeleteMapping("/book/{bookid}")
    private ResponseEntity<Boolean> delete(@PathVariable("bookid")int bookid){
        bookService.delete(bookid);
        return ResponseEntity.ok(true);
    }
    @PostMapping("/books")
    private int saveBook(@RequestBody BookEntity bookEntity){
        bookService.saveOrUpdate(bookEntity);
        return bookEntity.getBookId();
    }
    @PutMapping("/books")
    private BookEntity update(@RequestBody BookEntity bookEntity){
        bookService.update(bookEntity);
        return bookEntity;
    }



}
