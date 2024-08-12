package com.example.application.Repo;

import com.example.application.entry.journalentry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<journalentry, ObjectId> {
}
