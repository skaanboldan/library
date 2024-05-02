package com.project.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String transactionType;
    Date  transactionDate;
    String status;
    Long userId;

    public Transactions( String transactionType, Date transactionDate, String status, Long userId) {
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.status = status;
        this.userId = userId;
    }
}
