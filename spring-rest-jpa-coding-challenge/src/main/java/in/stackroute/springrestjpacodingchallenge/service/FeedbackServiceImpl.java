package in.stackroute.springrestjpacodingchallenge.service;

import in.stackroute.springrestjpacodingchallenge.domain.Feedback;
import in.stackroute.springrestjpacodingchallenge.repository.FeedbackRepository;
import in.stackroute.springrestjpacodingchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Feedback> getAllFeedbackByProductId(int pid) {
        final var list = feedbackRepository.findAll();
        List<Feedback> newArray  = new ArrayList<>();
        for(Feedback feedback:list){
            if(feedback.getProduct().getProductId()==pid){
                newArray.add(feedback);
            }
        }
        return newArray;
    }

    @Override
    public Feedback addToFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbackByUserId(int uid) {
        final var user = userRepository.findById(uid);
        final var feedbackList = feedbackRepository.findByUser(user.get());
        return feedbackList;
    }

    @Override
    public Feedback updateFeedback(int fid, Feedback feedback) {
        final var list = feedbackRepository.findById(fid);
        if(list.isPresent()){
            feedbackRepository.save(feedback);
        }
        return list.get();
    }

    @Override
    public Feedback deleteFeedback(int fid) {
        final var list = feedbackRepository.findById(fid);
        if(list.isPresent()){
            feedbackRepository.delete(list.get());
        }
        return list.get();
    }
}
