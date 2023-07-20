package in.stackroute.ust.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voting")
public class VotingController {
    @GetMapping("/check/{name}/{age}")
    public String check(@PathVariable String name,@PathVariable int age){
        if(age>=18){
            return "Ok for Voting";
        }
        else {
            return "Cannot Vote";
        }
    }
}
