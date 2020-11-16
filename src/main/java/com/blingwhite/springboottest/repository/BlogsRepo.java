package com.blingwhite.springboottest.repository;

import com.blingwhite.springboottest.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepo extends JpaRepository<Blogs, Integer> {
}
