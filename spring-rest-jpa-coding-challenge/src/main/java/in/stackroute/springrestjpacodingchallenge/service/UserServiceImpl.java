package in.stackroute.springrestjpacodingchallenge.service;

import in.stackroute.springrestjpacodingchallenge.domain.User;
import in.stackroute.springrestjpacodingchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }
}
