package in.stackroute.ust.training;

import java.time.LocalDate;
import java.util.Set;

public class Batch {
    private Set<Student> students;

    private Schedule schedule;

    private LocalDate startDate;

    private LocalDate endDate;

    private Mentor mentor;

    public Batch(Set<Student> students, Schedule schedule, LocalDate startDate, LocalDate endDate, Mentor mentor) {
        this.students = students;
        this.schedule = schedule;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mentor = mentor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
