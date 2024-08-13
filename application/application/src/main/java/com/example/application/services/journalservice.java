package com.example.application.services;

import com.example.application.Repo.JournalRepository;
import com.example.application.entry.User;
import com.example.application.entry.journalentry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalservice {
    @Autowired
    private UserService userService;
    @Autowired
    private JournalRepository journalRepository;
    public void saveEntry(journalentry journalentry, String userName){
        User user=userService.findByUserName(userName);
        journalentry saved = journalRepository.save(journalentry);
        user.getJournalentries().add(saved);
        userService.saveEntry(user);
    }
    public List<journalentry> getAll() {
    return journalRepository.findAll();
    }
    public Optional<journalentry> findById(ObjectId id){
        return journalRepository.findById(id);
    }
    public void deletebyid(ObjectId id, String userName){
        User user=userService.findByUserName(userName);
        user.getJournalentries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalRepository.deleteById(id);
    }


}
