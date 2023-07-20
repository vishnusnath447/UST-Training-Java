package in.stackroute.ust.domain;

import org.springframework.stereotype.Component;

@Component
public class Greet {
    private String message = "Hello";
    public Greet(){}

    public Greet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
