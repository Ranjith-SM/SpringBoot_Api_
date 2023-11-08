package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findAllTodo() {
        return jdbcTemplate.query("SELECT * FROM spring_todo;", new BeanPropertyRowMapper<>(Todo.class));
    }

    public Todo findTodo(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM spring_todo WHERE id=?;", new Object[]{id}, new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> addTodo(Todo todo) {
        jdbcTemplate.update("INSERT INTO spring_todo (item) VALUES(?);",
                new Object[]{todo.getId(), todo.getItem()});
        return findAllTodo();
    }

    public List<Todo> updateTodo(Todo todo) {
        jdbcTemplate.update("UPDATE spring_todo SET item=? WHERE id = ?;",
                new Object[]{todo.getItem(),todo.getId()});
        return findAllTodo();
    }

    public List<Todo> deleteTodo(int id) {
        jdbcTemplate.update("DELETE FROM spring_todo WHERE id=?", new Object[]{id});
        return findAllTodo();
    }
}
