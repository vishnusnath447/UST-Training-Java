package in.stackroute.ust.domain;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "reminder")
    private String reminder;

    @Column(name = "todo_completed")
    private boolean completed;

    public Todo() {
    }

    public Todo(int id, String reminder, boolean completed) {
        this.id = id;
        this.reminder = reminder;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReminder() {
        return reminder;
    }

    public boolean getCompleted(){return completed;}

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
