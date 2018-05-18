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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "form/login";
    }

    @PostMapping("/login")
    String login(@Valid User user, BindingResult result) {

        User checkUser = userRepository.getUserByUsername(user.getUsername());


        user.setEmail(checkUser.getEmail());

        if (BCrypt.checkpw(user.getPassword(), checkUser.getPassword())) {

            session.invalidate();
            session.setAttribute("loggedUser", checkUser.getUsername());
            return "redirect:/";
        } else {
            return "form/login";
        }
    }
}
