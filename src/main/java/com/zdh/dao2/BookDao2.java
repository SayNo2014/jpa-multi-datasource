package com.zdh.dao2;

import com.zdh.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookDao2 extends JpaRepository<Book,Integer> {
    @Query(value = "update book set auther=:auther  where id=:id",nativeQuery = true)
    @Modifying
    @Transactional
    int update(@Param("id") int id, @Param("auther") String auther);
}