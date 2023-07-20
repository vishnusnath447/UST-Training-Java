package in.stackroute.ust.service;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements ServiceInterface {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User saveData(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteData(Long id) {
        userRepository.deleteById(id);
    }
}
