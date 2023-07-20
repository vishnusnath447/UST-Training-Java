package in.stackroute.ust.training;

import java.util.Set;

public class Mentor {

    private String name;
    private String email;
    private Set<String> skills;

    public Mentor(String name, String email, Set<String> skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
