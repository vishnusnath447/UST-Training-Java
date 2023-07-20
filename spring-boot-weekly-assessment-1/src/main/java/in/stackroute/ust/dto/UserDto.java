package in.stackroute.ust.dto;

public record UserDto(long id,String name,String email,String password) {
    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
