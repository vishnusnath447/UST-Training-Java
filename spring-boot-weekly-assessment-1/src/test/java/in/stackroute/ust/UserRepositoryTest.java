package in.stackroute.ust;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {
    private User user;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        user = new User(1,"Vishnu","vishnusnath447@gmail.com","password");
    }
    @AfterEach
    void tearDown(){
        user=null;
    }

    @Test
    void testSaveUser(){
        userRepository.save(user);
        final var result = userRepository.findById(user.getId());
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(),user.getId());
        assertEquals(result.get().getName(),user.getName());
        assertEquals(result.get().getEmail(),user.getEmail());
        assertEquals(result.get().getPassword(),user.getPassword());
    }
}
