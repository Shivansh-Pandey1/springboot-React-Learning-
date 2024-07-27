package com.example.application.controller.entry;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("journal")
@Data
public class journalentry {
    @Id
    private ObjectId id;
    private String tittle;
    private String content;
    private LocalDateTime date;


}
