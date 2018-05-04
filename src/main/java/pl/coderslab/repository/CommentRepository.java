package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select  c from Comment c where c.id = :id order by c.created")
    List<Comment> getAllByTweetId(@Param("id") Long id);

    @Query("select c from Comment c where c.tweet = :tweet order by c.created")
    List<Comment> getAllByTweet(@Param("tweet") Tweet tweet);
}
