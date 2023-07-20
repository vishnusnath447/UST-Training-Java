package in.stackroute.ust.Controller;

import in.stackroute.ust.Domain.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {

    private List<ToDo> toDoList = new ArrayList<>();

    @PostMapping("")
    public ToDo createToDo(@RequestBody ToDo toDo){
        if(getOne(toDo.getId())==null){
            toDoList.add(toDo);
        }
        return toDo;
    }

    @GetMapping("")
    public List<ToDo> getAll(){
        return toDoList;
    }

    @GetMapping("{id}")
    public ToDo getOne(@PathVariable int id){
        return toDoList.stream().filter(todo->todo.getId()==id).findFirst().orElse(null);
    }

    @PutMapping("{id}")
    public ToDo update(@PathVariable int id,@RequestBody ToDo toDo){
        toDoList.remove(getOne(id));
        toDoList.add(toDo);
        return toDo;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        ToDo item = getOne(id);
        if(item!=null){
            toDoList.remove(item);
            return "Deleted";
        }
        return "Cannot find the record";
    }
}
