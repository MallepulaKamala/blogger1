package com.blog.repository;

import com.blog.entity.post;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PostRepository extends JpaRepository<post, Long> {
}
