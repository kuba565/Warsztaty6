package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Message;
import pl.coderslab.model.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MessagesController {

    @Autowired
    private HttpSession session;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/messages")
    public String messagesList(Model model) {
        List<Message> messages = messageRepository.findAll();

        model.addAttribute("messages", messages);
        model.addAttribute("message", new Message());

        return "userMessages";
    }

    @PostMapping("/messages")
    String addMessage(@Valid Message message, BindingResult result) {
        if (result.hasErrors()) {
            return "userMessages";
        }

        String username = (String) session.getAttribute("loggedUser");
        User sender = userRepository.getUserByUsername(username);
        message.setSender(sender);

        String recipientName = message.getRecipientString();
        User recipient = userRepository.getUserByUsername(recipientName);
        message.setRecipient(recipient);


        if (!username.equals(recipientName)) {
            messageRepository.save(message);
        } else {
            return "userMessages";
        }

        return "userMessages";
    }

    @GetMapping("/messageInfo/{id}")
    public String messagesList(Model model, @PathVariable Long id) {
        Message message = messageRepository.getOne(id);
        message.setRead(true);
        messageRepository.save(message);
        model.addAttribute("message", message);

        return "messageInfo";
    }

}
