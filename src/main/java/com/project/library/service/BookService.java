package com.project.library.service;

import com.project.library.model.Book;
import com.project.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book saveBook(Book book){
        return repository.save(book);
    }
    public List<Book> saveBooks(List<Book> book){
        return repository.saveAll(book);
    }
    public List<Book> getBooks (){
        return repository.findAll();
    }
    public Book getBookById (long id){
        return repository.findById(id).orElse(null);
    }

    public  long countBook(){
        return repository.count();
    }

    public void decreaseBookQuantity(Long bookId) {
        Book book = repository.findById(bookId).orElseThrow(() -> new RuntimeException("Kitap bulunamadı."));
        int currentQuantity = Math.toIntExact(book.getQuantity());
        if (currentQuantity == 0L) {
            throw new RuntimeException("Stok miktarı zaten sıfır.");
        }
        book.setQuantity(currentQuantity - 1);
        repository.save(book);
    }

    public void increaseBookQuantity(Long bookId) {
        Book book = repository.findById(bookId).orElseThrow(() -> new RuntimeException("Kitap bulunamadı."));
        int currentQuantity = Math.toIntExact(book.getQuantity());
        book.setQuantity(currentQuantity + 1);
        repository.save(book);
    }

}
