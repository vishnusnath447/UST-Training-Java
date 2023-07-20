package in.stackroute.springrestjpacodingchallenge.repository;

import in.stackroute.springrestjpacodingchallenge.domain.Feedback;
import in.stackroute.springrestjpacodingchallenge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    List<Feedback> findByUser(User user);
}
