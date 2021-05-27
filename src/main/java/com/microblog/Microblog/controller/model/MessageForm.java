package com.microblog.Microblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MessageForm {

    public MessageForm (MessageEntity message) {
        this.id = message.getId();
        this.content = message.getContent();
        this.date = message.getDate();

    }


    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String content;
}