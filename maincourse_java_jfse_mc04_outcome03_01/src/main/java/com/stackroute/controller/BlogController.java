package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    private BlogService blogService;
    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        var result = blogService.getBlogById(blog.getBlogId());
        if(result!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.saveBlog(blog));
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogList = blogService.getAllBlogs();
        if(blogList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(blogList);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        Blog blog = blogService.getBlogById(id);
        if(blog == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(blog);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.deleteBlog(id));
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        Blog item = blogService.getBlogById(blog.getBlogId());
//        if(item==null){
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//        item.setBlogId(blog.getBlogId());
//        item.setBlogTitle(blog.getBlogTitle());
//        item.setAuthorName(blog.getAuthorName());
//        item.setBlogContent(blog.getBlogContent());
        return ResponseEntity.status(HttpStatus.OK).body(blogService.updateBlog(item));
    }
}