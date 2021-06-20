package com.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "lendings")
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idLending;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Lending() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdLending() {
        return idLending;
    }

    public void setIdLending(int idLending) {
        this.idLending = idLending;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
