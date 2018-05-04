package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageController {


    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HttpSession session;


    @RequestMapping("/tweets")
    public String tweetsList(Model model) {
        String username = (String) session.getAttribute("loggedUser");
        User user = userRepository.getUserByUsername(username);
        Long id = user.getId();

        List<Tweet> tweets = tweetRepository.getAllByUserId(id);

        model.addAttribute("usersTweetList", tweets);

        return "userPage";
    }


}
