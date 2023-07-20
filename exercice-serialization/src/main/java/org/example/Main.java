package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        serialize();
        deSerialize();
    }
    static void serialize(){
        Batch batch = new Batch(10,"August Batch", LocalDate.of(2022,8,12),
              LocalDate.of(2023,8,12));
        Trainee trainee = new Trainee(1,"Vishnu","Ekm",batch);
        try {
            TraineeIO traineeIO = new TraineeIO();
            traineeIO.serialize(trainee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void deSerialize(){
        Trainee vishnu = null;
        try {
            TraineeIO traineeIO = new TraineeIO();
            vishnu = traineeIO.deSerialization();
            System.out.println(vishnu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}