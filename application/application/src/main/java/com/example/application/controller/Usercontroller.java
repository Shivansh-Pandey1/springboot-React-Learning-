package com.example.application.controller;

import com.example.application.entry.User;
import com.example.application.entry.journalentry;
import com.example.application.services.UserService;
import com.example.application.services.journalservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
    return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }
    @PutMapping("{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
        User userIndb=userService.findByUserName(userName);
        if(userIndb !=null){
            userIndb.setUserName(user.getUserName());
            userIndb.setPassword(user.getPassword());
            userService.saveEntry(userIndb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);




    }



}
