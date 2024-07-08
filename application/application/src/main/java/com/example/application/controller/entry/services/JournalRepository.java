package com.example.application.controller.entry.services;

import com.example.application.controller.entry.journalentry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<journalentry, ObjectId> {
}
