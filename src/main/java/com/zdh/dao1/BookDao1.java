package com.zdh.dao1;

import com.zdh.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookDao1 extends JpaRepository<Book,Integer> {

    //方法名可以靠拼接，相当于自定义sql
    List<Book> findBookByIdGreaterThanAndAndUsernameContains(Integer id, String usernames);

    @Query(value = "select count(*) from book",nativeQuery = true)
    long TotalCount();

    //如果sql语句不是查询，那么必须加@Modifying注解
    //另外在对数据库进行DML(update,delete,insert)操作时，必须加上事物，也就是@Transactional
    //@Transactional记得不要导错包
    //import org.springframework.transaction.annotation.Transactional;
    @Query(value = "update book set auther=:auther  where id=:id",nativeQuery = true)
    @Modifying
    @Transactional
    int update(@Param("id") int id, @Param("auther") String auther);

    @Query(value = "update book set bookname=:bookname  where id=:id",nativeQuery = true)
    @Modifying
    int update1(@Param("id") int id, @Param("bookname") String bookname);
}
