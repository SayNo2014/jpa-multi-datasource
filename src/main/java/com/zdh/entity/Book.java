package com.zdh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "book")
@Data
public class Book {
    //必须写个id
    @Id
    //也必须设置为主键，以及自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //给他起别名，  设置约束什么的也是@Column注解里去设置
    @Column(name = "bookname")
    private String username;

    private String auther;

    public Book() {
        super();
    }

    public Book(String username, String auther) {
        this.username = username;
        this.auther = auther;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", auther='" + auther + '\'' +
                '}';
    }
}