package in.stackroute.springrestjpacodingchallenge.service;

import in.stackroute.springrestjpacodingchallenge.domain.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> getAllFeedbackByProductId(int pid);

    Feedback addToFeedback(Feedback feedback);

    List<Feedback> getAllFeedbackByUserId(int uid);

    Feedback updateFeedback(int fid, Feedback feedback);

    Feedback deleteFeedback(int fid);
}
