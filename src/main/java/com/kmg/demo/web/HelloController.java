package com.kmg.demo.web;

import com.kmg.demo.domain.BookTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private BookTest book;

    @PostMapping("/hello")
//    @ResponseBody
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/books/{id}/{username:[a-z_]+}")
    public Object getOne(@PathVariable("id") long bookId, @PathVariable String username) {
        System.out.println("bookId: " + bookId);
        Map<String, Object> book = new HashMap<>();
        book.put("name", "互聯網世界觀");
        book.put("author", "李善友");
        book.put("isbn", "9788654543123");
        book.put("username", username);
        return book;
    }

    @PostMapping("/books")
    public Object post(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("isbn") String isbn) {
        Map<String, Object> book = new HashMap<>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);
        return book;
    }

    @GetMapping("/books")
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        Map<String, Object> book1 = new HashMap<>();
        book1.put("name", "互聯網世界觀");
        book1.put("author", "李善友");
        book1.put("isbn", "9788654543123");
        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "程序員的思維修練");
        book2.put("author", "author");
        book2.put("isbn", "1245679879453");
        List<Map<String, Object>> contents = new ArrayList<>();
        contents.add(book1);
        contents.add(book2);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("size", size);
        pageMap.put("content", contents);
        return pageMap;
    }

    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable("id") long bookId) {
        return book;
    }

}
