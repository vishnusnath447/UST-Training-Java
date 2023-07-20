package org.example;

import java.io.Serializable;

public class Trainee implements Serializable {
    private static final long serialVersionUID = 10L;
    private int empId;
    private String empName;
    private transient String empLocation;

    private Batch batch;

    public Trainee(){}

    public Trainee(int empId, String empName, String empLocation, Batch batch) {
        this.empId = empId;
        this.empName = empName;
        this.empLocation = empLocation;
        this.batch = batch;
    }
    @Override
    public String toString() {
        return "Trainee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empLocation='" + empLocation + '\'' +
                ", batch=" + batch +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
