package com.microblog.Microblog.controller;
import com.microblog.Microblog.model.MessageEntity;
import com.microblog.Microblog.model.MessageForm;
import com.microblog.Microblog.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageHTMLController {

    private final MessageService messageService;

    @GetMapping("/html/message/list")
    public String getAllMessages(Model model){ //Model - kontener do trzymania zmiennych dla thymeleafa
        List<MessageEntity> messages = messageService.findAll();
        model.addAttribute("messages", messages);
        return "message/list";
    }

    @GetMapping("/html/message/add") //odsyła do strony dodającej wiadomość
    public String addMessageForm(Model model) {
        model.addAttribute("messageForm", new MessageForm());
        model.addAttribute("messages", messageService.findAll());
        return "message/add";
    }

    @PostMapping("/html/message/add")                     //BindingResult używamy do walidacji danych w formularzu
    public String addMessageForm(MessageForm messageForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messageForm", messageForm);
            model.addAttribute("messages", messageService.findAll());
            return "message/add";
        }
        messageService.addNewMessage(messageForm.getContent());
        return "redirect:/html/message/list";
    }

    @GetMapping("/html/message/edit/{id}")
    public String editMessageForm(@PathVariable("id") Long id, Model model) {
        MessageEntity message = messageService.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no such message"));
        MessageForm messageForm = new MessageForm(message);
        model.addAttribute("messageForm", messageForm);
        model.addAttribute("messages", messageService.findAll());
        return "message/edit";
    }

    @PostMapping("/html/message/edit/{id}")
    public String editMessageFormPost(@PathVariable("id") Long id, Model model, @Valid MessageForm messageForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messageForm", messageForm);
            model.addAttribute("messages", messageService.findAll());
            return "message/edit";
        }
        messageService.update(id, messageForm);
        return "redirect:/html/message/list";
    }

    @GetMapping("/html/message/delete/{id}")
    public String deleteMessageForm(@PathVariable("id") Long id, Model model) {
        MessageEntity message = messageService.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no such message"));
        String askMessage = String.format("Do you really want to delete %s?", message.getDate());
        model.addAttribute("askMessage", askMessage);
        return "message/delete";
    }
    @PostMapping("/html/message/delete/{id}")
    public String deleteMessageFormPost(@PathVariable("id") Long id) {
        messageService.deleteById(id);
        return "redirect:/html/message/list";
    }
}