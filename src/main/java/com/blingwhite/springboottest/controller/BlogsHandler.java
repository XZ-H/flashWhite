package com.blingwhite.springboottest.controller;


import com.blingwhite.springboottest.entity.Blogs;
import com.blingwhite.springboottest.repository.BlogsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsHandler {
    private final BlogsRepo blogsRepo;

    public BlogsHandler(BlogsRepo blogsRepo) {
        this.blogsRepo = blogsRepo;
    }

    @GetMapping("/findAll")
    public List<Blogs> findAll(){
        return blogsRepo.findAll();
    }

    @GetMapping("/findById/{id}")
    public Blogs findById(@PathVariable("id") Integer id){
        return blogsRepo.findById(id).get();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Blogs> findAllWIthPages(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return blogsRepo.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody  Blogs blogs){
        Blogs result = blogsRepo.save(blogs);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody  Blogs blogs){
        Blogs result = blogsRepo.save(blogs);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
        public void deleteById(@PathVariable("id") Integer id){
            blogsRepo.deleteById(id);
        }
}
