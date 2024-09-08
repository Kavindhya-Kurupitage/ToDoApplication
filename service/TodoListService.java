package com.example.demo.service;

import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    // Create a new Todo List
    public TodoList createTodoList(TodoList todoList) {
        todoList.setCreatedDate(LocalDateTime.now());
        todoList.setUpdatedDate(LocalDateTime.now());
        return todoListRepository.save(todoList);
    }

    // Get all Todo Lists by a specific user
    public List<TodoList> getTodoListsByUser(Long userId) {
        return todoListRepository.findByUserId(userId);
    }

    // Delete a Todo List by ID
    public void deleteTodoList(Long id) {
        todoListRepository.deleteById(id);
    }

    // Update an existing Todo List
    public TodoList updateTodoList(TodoList todoList) {
        todoList.setUpdatedDate(LocalDateTime.now());
        return todoListRepository.save(todoList);
    }

    // Archive a Todo List (soft delete)
    public void archiveTodoList(Long id) {
        TodoList todoList = todoListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo List not found"));
        todoList.setArchived(true);  // Mark as archived
        todoListRepository.save(todoList);  // Save the updated state
    }
}
