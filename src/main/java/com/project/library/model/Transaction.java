package com.project.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "transaction")
public class Transaction {
    @Id
    private Long id;
    private LocalDateTime transactionDate;
    private boolean returned;


}

