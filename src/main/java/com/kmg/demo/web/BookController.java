package com.kmg.demo.web;

import com.kmg.demo.domain.Book;
import com.kmg.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books/input")
    public String inputPage() {
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book) { // html input 的 name 屬性，需和物件屬性名稱對應
        bookService.save(book);

        // redirect 重定向 => 相當於重新調用 url，而非返回靜態 books.html
        return "redirect:/books";
    }

}
