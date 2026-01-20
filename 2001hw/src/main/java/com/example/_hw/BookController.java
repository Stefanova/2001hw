package com.example._hw;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @GetMapping("/books/search?title")
    public List<Book> getAllBooks(@RequestParam String title) {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findByTitleContaining(title).forEach(books::add);
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") long id) {
        Optional<Book> bookData =
                bookRepository.findById(id);
        if (bookData.isPresent()) {
            return bookData.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(new Book(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishYear(), true));
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("id") long id,
                           @RequestBody Book book) {
        Optional<Book> bookData =
                bookRepository.findById(id);
        if (bookData.isPresent()) {
            Book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setAuthor(book.getAuthor());
            _book.setIsbn(book.getIsbn());
            _book.setPublishYear(book.getPublishYear());
            _book.setAvailable(book.getAvailable());
            return bookRepository.save(_book);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public HttpStatus deleteBook(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
