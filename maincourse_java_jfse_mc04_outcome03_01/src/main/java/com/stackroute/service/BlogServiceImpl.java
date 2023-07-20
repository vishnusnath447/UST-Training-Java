package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog deleteBlog(int id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if(blog==null){
            return null;
        }
        blogRepository.deleteById(blog.getBlogId());
        Blog result = blogRepository.findById(id).orElse(null);
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        if(blog!=null){
            var result  = blogRepository.findById(blog.getBlogId());
            if(!result.isEmpty()){
                var other = blogRepository.findById(result.get().getBlogId()).get();
                return blogRepository.save(other);
            }
        }
        return null;
    }
}
