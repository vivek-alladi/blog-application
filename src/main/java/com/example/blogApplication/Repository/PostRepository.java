package com.example.blogApplication.Repository;

import com.example.blogApplication.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
