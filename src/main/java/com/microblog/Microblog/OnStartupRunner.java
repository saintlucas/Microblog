package com.microblog.Microblog;

import com.microblog.Microblog.model.MessageEntity;
import com.microblog.Microblog.model.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class OnStartupRunner implements CommandLineRunner {

    private final MessageRepository messageRepository;

    @Override
    public void run(String... args) throws Exception {
        //dodanie 3 fake wiadomosci do repo
        MessageEntity m = new MessageEntity();
        m.setContent("Wiadomość 1");
        m.setDate(LocalDate.now());
        messageRepository.save(m);

        MessageEntity p = new MessageEntity();
        p.setContent("Wiadomość 2");
        p.setDate(LocalDate.now());
        messageRepository.save(p);

        MessageEntity u = new MessageEntity();
        u.setContent("Wiadomość 3");
        u.setDate(LocalDate.now());
        messageRepository.save(u);
    }
}
