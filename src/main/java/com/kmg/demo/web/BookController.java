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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book, RedirectAttributes attributes) { // html input 的 name 屬性，需和物件屬性名稱對應
        Book book1 = bookService.save(book);

        if (book1 != null){
            attributes.addFlashAttribute("message", "《" + book1.getName() + "》提交成功！");
        }

        // redirect 重定向 => 相當於重新調用 url，而非返回靜態 books.html
        return "redirect:/books";
    }

}
