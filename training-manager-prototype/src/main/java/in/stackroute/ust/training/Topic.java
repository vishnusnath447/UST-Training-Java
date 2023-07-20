package in.stackroute.ust.training;

import java.time.LocalDate;

public class Topic {
    private LocalDate startDate;
    private LocalDate endDate;
    private String topicName;

    public Topic(LocalDate startDate, LocalDate endDate, String topicName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.topicName = topicName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

}
