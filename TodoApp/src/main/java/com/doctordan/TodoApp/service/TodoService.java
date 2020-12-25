/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctordan.TodoApp.service;

import com.doctordan.TodoApp.domain.TodoItem;
import com.doctordan.TodoApp.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dan
 */
@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepo;
    
    public List<TodoItem> fetchAllTodoItems () {
        return todoRepo.fetchAllTodoItems();
    }
}
