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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dan
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class TodoController {
    
    @Autowired
    private TodoService todoService;
    
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems () {
       List<TodoItem> todoItems = todoService.fetchAllTodoItems();
       
       return ResponseEntity.ok(todoItems);
    }
    
    @PutMapping("/api/todoItems/{id}")
    public ResponseEntity<?> updateTodoItems (@PathVariable int id, @RequestBody TodoItem todoItem) {
       //call the service
       TodoItem updatedTodoItem = todoService.updateTodoItem(id,todoItem);
       
       //send to front end
       return ResponseEntity.ok(updatedTodoItem);
    }
}

    
    
