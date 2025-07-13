package com.blogspot.app.repositories;

import com.blogspot.app.entities.Category;
import com.blogspot.app.entities.Post;
import com.blogspot.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByPostTitleContaining(String keyword);
}
