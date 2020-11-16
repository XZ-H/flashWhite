package com.blingwhite.springboottest.repository;

import com.blingwhite.springboottest.entity.Blogs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
class BlogsRepoTest {
    @Autowired
    private BlogsRepo blogsRepo;

    @Test
    void findAll(){
        System.out.println(blogsRepo.findAll());
    }

    @Test
    void findAllwithPage(){
        Pageable pageable = PageRequest.of(0,6);
        System.out.println(blogsRepo.findAll(pageable));
    }

    @Test
    void findById(){
        System.out.println(blogsRepo.findById(1));
    }

    @Test
    void save() {
        Blogs blogs = new Blogs();
        blogs.setTitle("es6语法");
        blogs.setText("es6语法学习笔记");
        blogs.setCategory("es6");
        blogs.setAuthor("刘同学");
        Blogs blogs1 = blogsRepo.save(blogs);
        System.out.println(blogs1);
    }

    @Test
    void update(){
        Blogs blogs = new Blogs();
        blogs.setId(32);
        blogs.setTitle("es6语法");
        blogs.setText("es6语法学习笔记");
        blogs.setCategory("es6");
        blogs.setAuthor("刘同学");
        Blogs blogs1 = blogsRepo.save(blogs);
        System.out.println(blogs1);
    }

    @Test
    void delete(){
        blogsRepo.deleteById(33);
    }
}