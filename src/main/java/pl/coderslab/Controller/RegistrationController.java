package pl.coderslab.Controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "form/registration";
    }

    @PostMapping("/registration")
    String registration(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "form/registration";
        }

        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        userRepository.save(user);
        return "redirect:/";
    }

}
