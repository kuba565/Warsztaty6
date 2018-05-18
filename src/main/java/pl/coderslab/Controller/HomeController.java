package pl.coderslab.Controller;

import jdk.nashorn.internal.objects.AccessorPropertyDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {


    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private CommentRepository commentRepository;


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
        List<Comment> comments = commentRepository.getAllByTweet(tweet);

        model.addAttribute("tweet", tweet);
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentsList", comments);

        return "tweetInfo";
    }

    @PostMapping("/tweetInfo/{id}")
    String addComment(@Valid Comment comment, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "tweetInfo/{id}";
        }

        Tweet tweet = tweetRepository.getOne(id);

        String username = (String) session.getAttribute("loggedUser");

        User user = userRepository.getUserByUsername(username);


        comment.setUser(user);
        comment.setTweet(tweet);

        commentRepository.save(comment);
        return "redirect:/tweetInfo/{id}";
    }

}
