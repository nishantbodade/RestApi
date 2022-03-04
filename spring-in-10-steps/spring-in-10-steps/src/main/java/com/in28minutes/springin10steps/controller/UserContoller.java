package com.in28minutes.springin10steps.controller;

import com.in28minutes.springin10steps.model.User;
import com.in28minutes.springin10steps.services.UserService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserContoller{

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUsers(@PathVariable int id){
        return service.findOne(id);
    }
}
