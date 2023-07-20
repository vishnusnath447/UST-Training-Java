package in.stackroute.ust.controller;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.dto.UserDto;
import in.stackroute.ust.service.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ServiceInterface userService;

    public UserDto convertToDto(User user){
        return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPassword());
    }

    public User convertToEntity(UserDto userDto){
        return new User(userDto.id(),userDto.name(),userDto.email(),userDto.password());
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> userList = userService.getAll();
        List<UserDto> userDtoList = userList.stream().map(this::convertToDto).collect(Collectors.toList());
        if(userDtoList.isEmpty()){
            logger.info("There is no content in the database");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        logger.info("List : "+userDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id){
        User user = userService.getById(id);
        if(user == null){
            logger.info("There is no content with id : "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        logger.info("Data: "+convertToDto(user));
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(user));
    }

    @PostMapping("")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        User item = userService.getById(userDto.id());
        if(item!=null){
            logger.info("A record with id: "+userDto.id()+" already exist");
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        logger.info("User Dto Passed : "+userDto);
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(userService.saveData(convertToEntity(userDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id,@RequestBody UserDto userDto){
        User updatedUser = userService.getById(id);
        if(updatedUser==null){
            logger.info("There is no content with id : "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        updatedUser.setName(userDto.name());
        updatedUser.setEmail(userDto.email());
        updatedUser.setPassword(userDto.password());
        logger.info("Updated record : "+updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(userService.update(updatedUser)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable long id){
        User item = userService.getById(id);
        if(item==null){
            logger.info("There is no record with id: "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userService.deleteData(id);
        logger.info("Deleted item : "+item);
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(item));
    }
}
