package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class Batch implements Serializable {
   private static final long serialVersionUID = 10L;
    private int batchId;
    private String desc;
    private LocalDate start;
    private LocalDate end;

    public Batch(){}

    public Batch(int batchId, String desc, LocalDate start, LocalDate end) {
        this.batchId = batchId;
        this.desc = desc;
        this.start = start;
        this.end = end;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", desc='" + desc + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
