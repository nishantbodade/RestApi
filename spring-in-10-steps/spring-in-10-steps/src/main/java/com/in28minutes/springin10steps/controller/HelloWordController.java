package com.in28minutes.springin10steps.controller;

import com.in28minutes.springin10steps.model.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWordController {

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/helloWorld/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
