package in.stackroute.ust.controller;

import in.stackroute.ust.domain.Arithmetic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/add/{a}/{b}")
    public Arithmetic add(@PathVariable int a, @PathVariable int b){
        return new Arithmetic(a,b,(a+b),'+');
    }

    @GetMapping("/sub/{a}/{b}")
    public Arithmetic sub(@PathVariable int a, @PathVariable int b){
        return new Arithmetic(a,b,(a-b),'-');
    }

    @GetMapping("/mul/{a}/{b}")
    public Arithmetic mul(@PathVariable int a, @PathVariable int b){
        return new Arithmetic(a,b,(a*b),'/');
    }

    @GetMapping("/div/{a}/{b}")
    public Arithmetic div(@PathVariable int a, @PathVariable int b){
        return new Arithmetic(a,b,(a/b),'/');
    }
}
