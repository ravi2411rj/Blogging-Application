package com.blogspot.personal_blog.repositories;

import com.blogspot.personal_blog.entities.Category;
import com.blogspot.personal_blog.entities.Post;
import com.blogspot.personal_blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByPostTitleContaining(String keyword);
}
