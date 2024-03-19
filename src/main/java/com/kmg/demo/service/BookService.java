package com.kmg.demo.service;

import com.kmg.demo.domain.Book;
import com.kmg.demo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(long id) {
        return bookRepository.findById(id).isPresent() ? bookRepository.findById(id).get() : new Book();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByDescriptionContains(String description) {
        return bookRepository.findByDescriptionContains(description);
    }

    @Transactional
    public int updateBySql(int status, long id) {
        return bookRepository.updateBySql(status, id);
    }

    public Page<Book> findAllByPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(1, 5);
        Pageable pageable = PageRequest.of(0, 5, sort); // 每頁5筆，第0頁
        return bookRepository.findAll(pageable);
    }

}
