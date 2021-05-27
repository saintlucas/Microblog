package com.microblog.Microblog.service;

import com.microblog.Microblog.model.MessageEntity;
import com.microblog.Microblog.model.MessageForm;
import com.microblog.Microblog.model.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

//    public void save(MessageEntity updatedMessage, Long messageId){
//
//        MessageEntity messageToUpdate = messageRepository.findById(messageId)
//                .orElseThrow(()->new IllegalArgumentException("Message with such id doesn't exist"));
//        messageToUpdate.setContent(updatedMessage.getContent());
//        messageToUpdate.setDate(updatedMessage.getDate());
//        messageRepository.save(messageToUpdate);
//    }

    public void save(MessageEntity message) {
        messageRepository.save(message);
    }

    public void addNewMessage(String content) {
//        User user = userRepository.findById(petId)
//                .orElseThrow(() -> new IllegalArgumentException("Wrong user id param."));
//        Comment comment = commentRepository.findById(vetId)
//                .orElseThrow(() -> new IllegalArgumentException("Wrong comment id param."));
        MessageEntity message = new MessageEntity();
        message.setContent(content);
        message.setDate(LocalDate.now());
        //newMessage.setuser(id);
        //newMessage.setComment(id);
        save(message);
    }

    public void update(Long id, MessageForm messageForm) {
        MessageEntity messageToUpdate = messageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Message does not exist"));

        messageToUpdate.setContent(messageForm.getContent());
        messageRepository.save(messageToUpdate);
    }

    public List<MessageEntity> findAll() {
        return messageRepository.findAll();
    }

    public MessageEntity getLatestMessage() {
        return null;
    }

    public Optional<MessageEntity> findById(Long id) {
        return messageRepository.findById(id);
    }

    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
}
