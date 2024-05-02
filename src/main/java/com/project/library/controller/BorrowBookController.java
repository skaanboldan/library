package com.project.library.controller;

import com.project.library.model.BorrowBook;
import com.project.library.model.Transactions;
import com.project.library.repository.TransactionsRepository;
import com.project.library.service.BlackListService;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private BlackListService blackListService;


    @PostMapping("/book/borrow")
    public String borrowBook(@RequestBody BorrowBook borrowBook){
        if(blackListService.isBlackListedUser(borrowBook.getUserId())){
            return "Cant borrow this book, user in blacklist!!";
        }
        else {
            try {
                bookService.decreaseBookQuantity(borrowBook.getBookId());
                Transactions transaction = new Transactions(
                        "borrow_book",
                        new java.sql.Date(new java.util.Date().getTime()),
                        "completed",
                        borrowBook.getUserId());
                transactionsRepository.save(transaction);
                return "Succesfully borrowed...";
            } catch (Exception E)
            {
                return "An error occurred while processing your request.";
            }

        }

    }


    @PostMapping("/book/return")
    public String returnBorrowedBook(@RequestBody BorrowBook borrowBook){
        Transactions transaction=new Transactions(
                "return_borrowed_book",
                new java.sql.Date(new java.util.Date().getTime()),
                "completed",
                borrowBook.getUserId());



        try {
            bookService.increaseBookQuantity(borrowBook.getBookId());
            transactionsRepository.save(transaction);
            return "Succesfully returned...";
        } catch (Exception E)
        {
            return E.getMessage();
        }

    }





}
