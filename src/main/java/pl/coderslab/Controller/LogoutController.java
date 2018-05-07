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
public class LogoutController {


    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    String loginForm(Model model) {
        session.invalidate();
        return "home";
    }


}
