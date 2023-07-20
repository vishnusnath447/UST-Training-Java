package in.stackroute.springrestjpacodingchallenge.service;

import in.stackroute.springrestjpacodingchallenge.domain.User;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    Optional<User> getById(int id);
}
