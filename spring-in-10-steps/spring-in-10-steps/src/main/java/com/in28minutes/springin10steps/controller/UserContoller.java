package com.in28minutes.springin10steps.controller;

import com.in28minutes.springin10steps.exception.UserNotFoundException;
import com.in28minutes.springin10steps.model.User;
import com.in28minutes.springin10steps.services.UserService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user=service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    @PostMapping("/user")
    public ResponseEntity save(@RequestBody User user){
        User saveUser= service.save(user);
       URI location= ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(saveUser.getId()).toUri();
      return   ResponseEntity.created(location).build();

    }
}
