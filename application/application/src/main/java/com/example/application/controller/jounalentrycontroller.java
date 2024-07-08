package com.example.application.controller;

import com.example.application.controller.entry.journalentry;
import com.example.application.controller.entry.services.journalservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Journal")
public class jounalentrycontroller {
@Autowired

private journalservice journalservice;
    @GetMapping
    public List<journalentry> getAll(){
       return journalservice.getAll();
    }
    @GetMapping("id/{myid}")
    public ResponseEntity<journalentry> getJournalEntrybyid(@PathVariable ObjectId myid){
        Optional<journalentry> journalentry=journalservice.findById(myid);
       if(journalentry.isPresent()){
           return new ResponseEntity<>(journalentry.get(), HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public boolean createEntry(@RequestBody journalentry myentry){
        myentry.setDate(LocalDateTime.now());
        journalservice.saveEntry(myentry);
        return true;
    }
@DeleteMapping("id/{myId}")
    public boolean deleteEntrybyid(@PathVariable ObjectId myId){
        journalservice.deletebyid(myId);
        return true;
}
@PutMapping("id/{id}")
    public journalentry updatejournalentrybyid(@PathVariable ObjectId id,@RequestBody journalentry newentry){
    journalentry old=journalservice.findById(id).orElse(null);
    if(old !=null){
        old.setTiitle(newentry.getTittle()!=null && !newentry.getTittle().equals("")? newentry.getTittle() : old.getTittle());
        old.setContent(newentry.getContent() !=null && !newentry.equals("")?newentry.getContent(): old.getContent());
    }
    journalservice.saveEntry(old);
            return old;
}
}
