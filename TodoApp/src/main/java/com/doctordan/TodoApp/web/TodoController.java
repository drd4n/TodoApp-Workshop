/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctordan.TodoApp.web;

import com.doctordan.TodoApp.domain.TodoItem;
import com.doctordan.TodoApp.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dan
 */
@RestController
public class TodoController {
    
    @Autowired
    private TodoService todoService;
    
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems () {
       List<TodoItem> todoItems = todoService.fetchAllTodoItems();
       
       return ResponseEntity.ok(todoItems);
    }
}
