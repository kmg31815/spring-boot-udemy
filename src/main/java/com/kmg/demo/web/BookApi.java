package com.kmg.demo.web;

import com.kmg.demo.domain.Book;
import com.kmg.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookApi {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Page<Book> getAll(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
//  public Page<Book> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
//        return bookService.findAll();
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(page, size, sort);
        return bookService.findAllByPage(pageable);
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    @PostMapping("/books")
//    public Book create(@RequestParam String name,
//                       @RequestParam String author,
//                       @RequestParam String description,
//                       @RequestParam int status) {
    public Book create(Book book) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
        return bookService.save(book);
    }

    @PutMapping("/books")
    public Book update(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        return bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }

    @PostMapping("/books/by")
    public List<Book> findBy(@RequestParam String description) {
        return bookService.findByDescriptionContains(description);
    }

    @PostMapping("/books/update_by")
    public int updateBy(@RequestParam int status, @RequestParam long id) {
        return bookService.updateBySql(status, id);
    }

}
