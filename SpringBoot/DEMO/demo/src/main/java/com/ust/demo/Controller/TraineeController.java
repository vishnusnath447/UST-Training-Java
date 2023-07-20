package com.ust.demo.Controller;

import com.ust.demo.Entity.Trainee;
import com.ust.demo.Service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraineeController {

    @Autowired
    TraineeService traineeService;

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/trainee")
    public void addTrainee(@RequestBody Trainee trainee){
        traineeService.add(trainee);
        System.out.println("Added");
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/trainees")
    public ResponseEntity<List<Trainee>> getAll(){
        List<Trainee> result = traineeService.find();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
