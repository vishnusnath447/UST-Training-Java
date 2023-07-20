package com.ust.demo.Service;

import com.ust.demo.Entity.Trainee;
import com.ust.demo.Repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {

    @Autowired
    TraineeRepository traineeRepository;

    public void add(Trainee trainee){
        traineeRepository.save(trainee);
    }

    public List<Trainee> find() {
        return traineeRepository.findAll();
    }
}
