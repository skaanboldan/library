package com.project.library.controller;

import com.project.library.model.Book;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class    BookController {
    @Autowired
    private BookService service;

    // Yeni bir kitap ekler
    @PostMapping("/book/add")
    public Book addBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    // Birden fazla kitap ekler
    @PostMapping("/book/add/multiple")
    public List<Book> addProducts(@RequestBody List<Book> book){
        return service.saveBooks(book);
    }

    // Tüm kitapları getirir ve önbelleğe alır
    @Cacheable("books")
    @GetMapping("/book/list")
    public List<Book> findAllBooks(){
        return service.getBooks();
    }

    // Belirli bir kitabı ID'ye göre getirir ve önbelleğe alır
    @Cacheable(value = "books", key = "#id")
    @GetMapping("/book/id/{id}")
    public Book findUserById(@PathVariable long id){
        return service.getBookById(id);
    }

    // Kitap sayısını döndürür
    @GetMapping("/book/count")
    public long getCountOfBooks(){
        return service.countBook();
    }
}
