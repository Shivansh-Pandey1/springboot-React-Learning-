package com.example.application.Repo;

import com.example.application.entry.User;
import com.example.application.entry.journalentry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByuserName(String userName);
}
