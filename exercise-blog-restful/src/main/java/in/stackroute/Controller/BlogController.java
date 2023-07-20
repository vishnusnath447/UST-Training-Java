package in.stackroute.Controller;

import in.stackroute.Domain.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    List<Blog> blogList = new ArrayList<>();

    @PostMapping("")
    public Blog create(@RequestBody Blog blog){
        Blog content = blogList.stream().filter(b->b.id()==blog.id()).findFirst().orElse(null);
        if(content==null){
            blogList.add(blog);
            return blog;
        }
        else return null;
    }
    @GetMapping("")
    public List<Blog> getAll(){
        return blogList;
    }

    @DeleteMapping("/{id}")
    public Blog delete(@PathVariable int id){
        Blog item = blogList.stream().filter(b->b.id()==id).findFirst().orElse(null);
        if(item!=null){
            blogList.remove(item);
            return item;
        }
        else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Blog update(@PathVariable int id,@RequestBody Blog blog){
        Blog item = blogList.stream().filter(b->b.id()==id).findFirst().orElse(null);
        if(item!=null){
            blogList.remove(item);
            blogList.add(blog);
            return blog;
        }
        else {
            return null;
        }
    }
}
