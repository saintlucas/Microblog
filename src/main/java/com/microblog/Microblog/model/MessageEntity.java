package com.microblog.Microblog.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Type;
import java.time.LocalDate;

@Entity
@Data
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    //private Enum<Type> typeOfMessage;

    //private Enum<StatusOfContent> statusOfMessageContent;

    private String ownerOfContent;
}
