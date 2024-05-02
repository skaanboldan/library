package com.project.library.service;

import com.project.library.model.Transactions;
import com.project.library.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository repository;

    /**
     * Belirli bir işlemi veritabanına ekler.
     * @param transactions Eklenecek işlem
     * @return Eklenen işlem
     */
    public Transactions addRowTransaction(Transactions transactions){
        return repository.save(transactions);
    }

    /**
     * Tüm işlemleri listeler.
     * @return Tüm işlemlerin listesi
     */
    public List<Transactions> listAllTransactions(){
        return repository.findAll();
    }

    /**
     * Belirli bir tarih aralığına göre filtrelenmiş işlemleri listeler.
     * @param startDate Başlangıç tarihi
     * @param endDate Bitiş tarihi
     * @return Belirli bir tarih aralığına göre filtrelenmiş işlemlerin listesi
     */
    public List<Transactions> listTransactionFilterByStartDateToEndDate(Date startDate, Date endDate){
        return repository.findByTransactionDateBetween(
                startDate,
                endDate
        );
    }

    /**
     * Belirli bir başlangıç tarihinden şu anki tarihe kadar olan işlemleri listeler.
     * @param startDate Başlangıç tarihi
     * @return Belirli bir başlangıç tarihinden şu anki tarihe kadar olan işlemlerin listesi
     */
    public List<Transactions> listTransactionFilterByStartDateToPresent(Date startDate){
        return repository.findByTransactionDateBetween(
                startDate,
                new java.sql.Date(new java.util.Date().getTime())
        );
    }

    /**
     * Belirli bir kullanıcıya ait işlemleri listeler.
     * @param userId Kullanıcı kimliği
     * @return Belirli bir kullanıcıya ait işlemlerin listesi
     */
    public List<Transactions> listTransactionByUserId(Long userId){
        return repository.findByUserId(userId);
    }

    /**
     * Bir işlemi veritabanına ekler.
     * @param transactions Eklenecek işlem
     * @return Eklenen işlem
     */
    public Transactions addTransaction(Transactions transactions){
        return repository.save(transactions);
    }

}
