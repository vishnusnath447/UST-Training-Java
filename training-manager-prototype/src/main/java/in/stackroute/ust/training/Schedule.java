package in.stackroute.ust.training;

import java.util.Set;

public class Schedule {
    private Set<Topic> topics;

    public Schedule(Set<Topic> topics) {
        this.topics = topics;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
