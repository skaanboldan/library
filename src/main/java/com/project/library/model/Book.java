package com.project.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    private Long book_id;
    private String title;
    private String author;
    private String publisher;
    private Date publication_date;
    private Long price;
    private  Long id;


}
