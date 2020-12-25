/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctordan.TodoApp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author Dan
 */
@Controller
public class WebController {
    
    @GetMapping("/hello")
    public String sayHello(Model model){
        System.out.println("Try Say");
        return "hello";
    }
}
