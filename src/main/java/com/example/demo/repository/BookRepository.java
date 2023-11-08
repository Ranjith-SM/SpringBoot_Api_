package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book;", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id=?;", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Book> insert(Book book) {
        jdbcTemplate.update("INSERT INTO book (id,name,author) VALUES(?,?,?);",
                new Object[]{book.getId(), book.getName(), book.getAuthor()});
        return findAll();
    }

    public List<Book> update(Book book) {
        jdbcTemplate.update("UPDATE book SET name=? , author=? WHERE id = ?;",
                new Object[]{book.getName(), book.getAuthor(), book.getId()});
        return findAll();
    }

    public List<Book> delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", new Object[]{id});
        return findAll();
    }
}
