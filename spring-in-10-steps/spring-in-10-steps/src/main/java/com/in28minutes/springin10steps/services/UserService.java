package com.in28minutes.springin10steps.services;

import com.in28minutes.springin10steps.model.User;
import com.in28minutes.springin10steps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findOne(int id) {
        return repository.findOne(id);
    }
}
