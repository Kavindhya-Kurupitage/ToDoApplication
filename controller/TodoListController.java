package com.example.demo.controller;

import com.example.demo.model.TodoList;
import com.example.demo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @PostMapping("/create")
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        TodoList newTodoList = todoListService.createTodoList(todoList);
        return ResponseEntity.ok(newTodoList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TodoList>> getTodoLists(@PathVariable Long userId) {
        List<TodoList> todoLists = todoListService.getTodoListsByUser(userId);
        return ResponseEntity.ok(todoLists);
    }

    @PutMapping("/update")
    public ResponseEntity<TodoList> updateTodoList(@RequestBody TodoList todoList) {
        TodoList updatedTodoList = todoListService.updateTodoList(todoList);
        return ResponseEntity.ok(updatedTodoList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
        return ResponseEntity.ok().build();
    }
}
