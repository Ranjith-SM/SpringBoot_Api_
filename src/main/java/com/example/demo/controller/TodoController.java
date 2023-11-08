package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;
    @GetMapping("/todos/all")
    public List<Todo> getAllTodos() {
        return todoRepository.findAllTodo();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoRepository.findTodo(id);
    }

    @PostMapping("/todos")
    public List<Todo> addTodo(@RequestBody Todo todo) {
        return todoRepository.addTodo(todo);
    }

    @PutMapping("/todos")
    public List<Todo> updateTodo(@RequestBody Todo todo) {
        return todoRepository.updateTodo(todo);
    }

    @DeleteMapping("/todos/{id}")
    public List<Todo> deleteTodo(@PathVariable int id) {
        return todoRepository.deleteTodo(id);
    }
}
