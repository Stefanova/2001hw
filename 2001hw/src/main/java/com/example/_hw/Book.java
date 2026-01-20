package com.example._hw;
import jakarta.persistence.*;

@Entity
@Table(name = "tutorials")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publishYear")
    private int publishYear;

    @Column(name = "available")
    private boolean available;

    public Book(String title, String author, String isbn, int publishYear, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.available = available;
    }
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean getAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + "]";
    }
}
