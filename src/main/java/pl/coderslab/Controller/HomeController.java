package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {


    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HttpSession session;


    @RequestMapping("/")
    public String tweetsList(Model model) {
        List<Tweet> tweets = tweetRepository.findAll();
        model.addAttribute("tweet", new Tweet());
        model.addAttribute("tweetsList", tweets);

        return "home";
    }

    @PostMapping("/")
    String addTweet(@Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "home";
        }

        String username = (String) session.getAttribute("loggedUser");

        User user = userRepository.getUserByUsername(username);

        tweet.setUser(user);
        tweetRepository.save(tweet);

        return "redirect:/";
    }

    @RequestMapping("/tweetInfo/{id}")
    public String tweetInfo(Model model, @PathVariable Long id) {
        Tweet tweet = tweetRepository.getOne(id);

        model.addAttribute("tweet", tweet);

        return "tweetInfo";
    }

}
