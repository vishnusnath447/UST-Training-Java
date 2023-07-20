package in.stackroute.ust.controller;

import in.stackroute.ust.domain.Todo;
import in.stackroute.ust.dto.TodoDto;
import in.stackroute.ust.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

//    @Autowired
//    private TodoRepository todoRepository;
//
//    OR
//
//    private TodoRepository todoRepository;
//    public TodoController(TodoRepository todoRepository){
//        this.todoRepository = todoRepository;
//    }

    private TodoRepository todoRepository;
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public TodoDto convertToDto(Todo todo){
        return new TodoDto(todo.getId(),todo.getReminder(),todo.getCompleted());
    }
    public Todo convertToEntity(TodoDto todoDto){
        return new Todo(todoDto.id(),todoDto.reminder(),todoDto.completed());
    }

    // POST     /api/v1/todos
    @PostMapping("")
    public TodoDto createTodo(@RequestBody TodoDto todoDto){
        return convertToDto(todoRepository.save(convertToEntity(todoDto)));
    }
    // GET      /api/v1/todos
    @GetMapping("")
    public List<TodoDto> getTodo(){
        List<TodoDto> todoDtoList = todoRepository.findAll().stream().map(this::convertToDto).toList();
        return todoDtoList;
    }
    // GET      /api/v1/todos/{id}
    @GetMapping("/{id}")
    public TodoDto getById(@PathVariable int id){
        return convertToDto(todoRepository.findById(id).orElse(null));
    }
    // PUT      /api/v1/todos/{id}
    @PutMapping("/{id}")
    public TodoDto update(@PathVariable int id,@RequestBody TodoDto todoDto){
        final var item = convertToEntity(getById(id));
        if(item==null){
            return null;
        }
        item.setReminder(todoDto.reminder());
        item.setCompleted(todoDto.completed());
        return convertToDto(todoRepository.save(item));
    }
    // DELETE   /api/v1/todos/{id}

}
