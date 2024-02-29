package com.kmg.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    //    List<Book> findByDescriptionEndsWith(String description);
    List<Book> findByDescriptionContains(String description);

    @Modifying // 自定義更新需加@Modifying，自定義查詢不用
    @Query("update Book b set b.status = ?1 where id = ?2")
    int updateBySql(int status, long id);

}
