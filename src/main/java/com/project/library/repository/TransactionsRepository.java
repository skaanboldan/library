package com.project.library.repository;

import com.project.library.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    List<Transactions> findByTransactionDateBetween(Date startDate, Date endDate);

    List<Transactions> findByUserId(Long userId);
}
