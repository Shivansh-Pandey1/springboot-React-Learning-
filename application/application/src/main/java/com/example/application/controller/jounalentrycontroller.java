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
@RequestMapping("/J")
public class jounalentrycontroller {
@Autowired

private journalservice journalservice;

@Autowired
private UserService userService;
    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
        User user=userService.findByUserName(userName);

        List<journalentry> all=user.getJournalentries();

       if(all != null && !all.isEmpty()){
           return  new ResponseEntity<>(all,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("{userName}")
    public ResponseEntity<journalentry> createEntry(@RequestBody journalentry myentry,@PathVariable String userName){

        try {

            myentry.setDate(LocalDateTime.now());
            journalservice.saveEntry(myentry,userName);
            return new ResponseEntity<>(myentry, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(myentry, HttpStatus.BAD_REQUEST);


        }
    }


    @GetMapping("id/{myid}")
    public ResponseEntity<journalentry> getJournalEntrybyid(@PathVariable ObjectId myid)
    {
        Optional<journalentry> journalentryOptional = journalservice.findById(myid);
        return journalentryOptional.map(journalentry -> new ResponseEntity<>(journalentry,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


@DeleteMapping("id/{userName}/{myId}")
    public ResponseEntity<?> deleteEntrybyid(@PathVariable ObjectId myId,@PathVariable String userName){
        journalservice.deletebyid(myId,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
@PutMapping("id/{id}")
    public ResponseEntity<?> updatejournalentrybyid(@PathVariable ObjectId id,@RequestBody journalentry newentry){
    journalentry old=journalservice.findById(id).orElse(null);
//    if(old !=null){
////        old.setTittle(newentry.getTittle()!=null && !newentry.getTittle().equals("")? newentry.getTittle() : old.getTittle());
////        old.setContent(newentry.getContent() !=null && !newentry.equals("")?newentry.getContent(): old.getContent());
////        journalservice.saveEntry(old, user);
////        return new ResponseEntity<>(old,HttpStatus.OK);
//    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
