package com.project.library.controller;

import com.project.library.model.Transaction;
import com.project.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Örnek olarak 10 iş parçacığı

    @CachePut(value = "transactions", key = "#transaction.id")
    @PostMapping("/transaction/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        executorService.submit(() -> service.addTransaction(transaction));
        return transaction;
    }

    @Cacheable("transactions")
    @GetMapping("/transaction/list")
    public List<Transaction> listAllTransation() {
        return service.listAllTransaction();
    }

    @Cacheable(value = "transactions", key = "#id")
    @GetMapping("/transaction/id/{id}")
    public Transaction findUserById(@PathVariable long id) {
        return service.listTransactionById(id);
    }

    @CacheEvict(value = "transactions", allEntries = true)
    public void clearCache() {
    }
}
