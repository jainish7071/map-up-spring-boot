package com.example.springbootproject.service;

import com.example.springbootproject.dao.BookRepo;
import com.example.springbootproject.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<BookEntity> getAllBooks(){
        List<BookEntity> books =new ArrayList<BookEntity>();
        bookRepo.findAll().forEach(books1->books.add(books1));
        return books;
    }

    public BookEntity getBookById(int id){
        return bookRepo.findById(id).orElse(null);
    }

    public void saveOrUpdate(BookEntity bookEntity){
        bookRepo.save(bookEntity);
    }
    public void delete(int id){
        bookRepo.deleteById(id);
    }

    public void update(BookEntity bookEntity){
        bookRepo.save(bookEntity);
    }
}
