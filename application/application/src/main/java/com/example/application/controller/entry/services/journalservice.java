package com.example.application.controller.entry.services;

import com.example.application.controller.entry.journalentry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalservice {
    @Autowired
    private JournalRepository journalRepository;
    public void saveEntry(journalentry journalentry){
        journalRepository.save(journalentry);
    }
    public List<journalentry> getAll() {
    return journalRepository.findAll();
    }
    public Optional<journalentry> findById(ObjectId id){
        return journalRepository.findById(id);
    }
    public void deletebyid(ObjectId id){
        journalRepository.deleteById(id);
    }
}
