package com.example.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class shivansh {
    @GetMapping("abc")
    public String he(){
        return "hellofgdddddddddddd";
    }
}
