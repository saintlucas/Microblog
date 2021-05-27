package com.microblog.Microblog.controller;
import com.microblog.Microblog.model.MessageEntity;
import com.microblog.Microblog.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message/add")
    public void addMessage(@RequestBody String content){
        messageService.addNewMessage(content);
    }

    @GetMapping("/message/list")
    public List<MessageEntity> getAllMessages(){
        return messageService.findAll();
    }

}