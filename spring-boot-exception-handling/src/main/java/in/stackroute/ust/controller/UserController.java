package in.stackroute.ust.controller;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.service.UserPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserPersistenceService userPersistenceService;
    // GET /api/v1/users?email=email
    @GetMapping("/search")
    public ResponseEntity<User> searchByEmail(@RequestParam String email){
        if(userPersistenceService.findByEmail(email).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userPersistenceService.findByEmail(email).get());
    }

    // GET /api/v1/users?email=email&password=password
    @GetMapping("/email/password")
    public ResponseEntity<User> searchByEmailAndPassword(@RequestParam String email,@RequestParam String password){
        if(userPersistenceService.findByEmailAndPassword(email,password).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userPersistenceService.findByEmailAndPassword(email,password).get());
    }
}
