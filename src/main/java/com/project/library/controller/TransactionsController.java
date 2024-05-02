package com.project.library.controller;

import com.project.library.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.project.library.model.Transactions;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionsService service;

    // Thread havuzu oluştur
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * Tüm işlemleri listeler.
     * @return Tüm işlemlerin listesi
     */
    @GetMapping("/transactions/list/all")
    public List<Transactions> listAllTransactions() {
        return service.listAllTransactions();
    }

    /**
     * Belirtilen başlangıç tarihinden itibaren işlemleri listeler.
     * @param startDate Başlangıç tarihi
     * @return Başlangıç tarihinden itibaren olan işlemlerin listesi
     */
    @Cacheable(value = "transactions", key = "#startDate.toString()")
    @GetMapping("/transaction/list/{startDate}")
    public List<Transactions> listTransactionFilterByStartDate(@PathVariable Date startDate) throws ExecutionException, InterruptedException {
        // Önbelleğe alınmış metodlar için thread havuzunda işlem gerçekleştirme
        return executorService.submit(() -> service.listTransactionFilterByStartDateToPresent(startDate)).get();
    }

    /**
     * Belirtilen başlangıç ve bitiş tarihleri arasındaki işlemleri listeler.
     * @param startDate Başlangıç tarihi
     * @param endDate Bitiş tarihi
     * @return Belirtilen tarih aralığındaki işlemlerin listesi
     */
    @Cacheable(value = "transactions", key = "#startDate.toString() + '_' + #endDate.toString()")
    @GetMapping("/transaction/list/{startDate}/{endDate}")
    public List<Transactions> listTransactionFilterBetweenStartDateToEndDate(
            @PathVariable Date startDate,
            @PathVariable Date endDate
    )throws ExecutionException, InterruptedException {
        // Önbelleğe alınmış metodlar için thread havuzunda işlem gerçekleştirme
        return executorService.submit(() -> service.listTransactionFilterByStartDateToEndDate(startDate, endDate)).get();
    }

    /**
     * Belirli bir kullanıcıya ait işlemleri listeler.
     * Önbellek kullanarak veritabanı erişimini azaltır.
     * @param userId Kullanıcı kimliği
     * @return Belirli bir kullanıcıya ait işlemlerin listesi (CompletableFuture ile asenkron olarak döndürülür)
     */
    @Cacheable("userTransactions")
    @GetMapping("/transaction/list/userId/{userId}")
    public List<Transactions> listTransactionFilterByUserId(@PathVariable Long userId) throws ExecutionException, InterruptedException {
        // Önbelleğe alınmış metodlar için thread havuzunda işlem gerçekleştirme
        return executorService.submit(() -> service.listTransactionByUserId(userId)).get();
    }

}
