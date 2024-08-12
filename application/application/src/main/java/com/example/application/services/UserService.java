package com.example.application.services;

import com.example.application.Repo.JournalRepository;
import com.example.application.Repo.UserRepository;
import com.example.application.entry.User;
import com.example.application.entry.journalentry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveEntry(User user){
        userRepository.save(user);
    }
    public List<User> getAll() {
    return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }
    public void deletebyid(ObjectId id){
        userRepository.deleteById(id);
    }

    public  User findByUserName(String userName){
        return userRepository.findByuserName(userName);
    }
}
