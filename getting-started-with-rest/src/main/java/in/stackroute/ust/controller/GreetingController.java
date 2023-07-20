package in.stackroute.ust.controller;

import in.stackroute.ust.domain.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    private Greet greet;
    @GetMapping("/hello")
    public Greet sayHello(){
        return greet;
    }

    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome";
    }
}
