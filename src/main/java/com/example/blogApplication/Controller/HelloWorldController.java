package com.example.blogApplication.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello-world";
    }
}
