package com.project.library.service;

import com.project.library.model.Transaction;
import com.project.library.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository repository;
    public Transaction addTransaction(Transaction transaction){
        return repository.save(transaction);
    }

    public List<Transaction> addTransactions(List<Transaction> transactions){
        return repository.saveAll(transactions);
    }
    public Transaction listTransactionById(long id){
        return repository.findById(id).orElse(null);
    }
    public List<Transaction> listAllTransaction(){
        return repository.findAll();
    }




}
