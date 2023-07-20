package com.stackroute.service;

import com.stackroute.domain.Blog;
import com.stackroute.execption.BlogAlreadyExistsException;
import com.stackroute.execption.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/* This is ServiceImplementation Class which should implement BlogService Interface and override all the implemented methods.
 * Handle suitable exceptions for all the implemented methods*/

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog saveBlog(Blog blog) {
        final var optionalBlog = blogRepository.findById(blog.getBlogId());
        if(optionalBlog.isPresent()){
            throw new BlogAlreadyExistsException();
        }
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        final var optionalBlog = blogRepository.findById(id);
        if(optionalBlog.isEmpty()){
            throw new BlogNotFoundException();
        }
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog deleteBlog(int id) {
        final var optionalBlog = blogRepository.findById(id);
        if(optionalBlog.isEmpty()){
            throw new BlogNotFoundException();
        }
        final var result = blogRepository.findById(id);
        blogRepository.deleteById(result.get().getBlogId());
        return optionalBlog.get();
    }

    @Override
    public Blog updateBlog(Blog blog) {
        final var optionalBlog = blogRepository.existsById(blog.getBlogId());
        if(!optionalBlog){
            throw new BlogNotFoundException();
        }
        return blogRepository.save(blog);
    }
}

