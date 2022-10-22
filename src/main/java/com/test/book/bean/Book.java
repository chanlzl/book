package com.test.book.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrator
 */
@Data
@Entity
public class Book {

    @Id
    private Integer id;

    private String name;

    private String author;
}
