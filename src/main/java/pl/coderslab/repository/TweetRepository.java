package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> getAllByUserId(Long id);

    List<Tweet> getAllByUser(User user);




}
