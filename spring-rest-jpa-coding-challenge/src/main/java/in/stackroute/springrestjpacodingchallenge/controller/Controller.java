package in.stackroute.springrestjpacodingchallenge.controller;

import in.stackroute.springrestjpacodingchallenge.domain.Feedback;
import in.stackroute.springrestjpacodingchallenge.domain.Product;
import in.stackroute.springrestjpacodingchallenge.dto.FeedbackDto;
import in.stackroute.springrestjpacodingchallenge.service.FeedbackService;
import in.stackroute.springrestjpacodingchallenge.service.ProductService;
import in.stackroute.springrestjpacodingchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ProductService productService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        final var list = productService.getAll();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/products/{pid}/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbackByProduct(@PathVariable int pid){
        final var list  = feedbackService.getAllFeedbackByProductId(pid);
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/products/{pid}/feedbacks")
    public ResponseEntity<Feedback> saveFeedback(@PathVariable int pid, @RequestBody FeedbackDto feedbackDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.addToFeedback(convertDtoToEntity(feedbackDto,pid)));
    }

    @GetMapping("/feedback/{uid}")
    public ResponseEntity<List<Feedback>> getAllFeedbackByUser(@PathVariable int uid){
        final var list = feedbackService.getAllFeedbackByUserId(uid);
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/feedbacks/{fid}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable int fid,@RequestBody Feedback feedback){
        final var list = feedbackService.updateFeedback(fid,feedback);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }

    @DeleteMapping("/feedbacks/{fid}")
    public ResponseEntity<Feedback> deleteFeedback(@PathVariable int fid,@RequestBody Feedback feedback){
        final var list= feedbackService.deleteFeedback(fid);
        return ResponseEntity.status(HttpStatus.OK).body(feedback);
    }

    public Feedback convertDtoToEntity(FeedbackDto feedbackDto,int pid){
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackDto.feedbackId());
        feedback.setComment(feedbackDto.comment());
        feedback.setUser(userService.getById(feedbackDto.userId()).get());
        feedback.setProduct(productService.getProductById(pid).get());
        return feedback;
    }
}
