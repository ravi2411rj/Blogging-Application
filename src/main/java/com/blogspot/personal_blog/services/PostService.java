package com.blogspot.personal_blog.services;

import com.blogspot.personal_blog.payloads.PostDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(Integer postId, PostDto postDto);

    void deletePost(Integer postId);

//    List<PostDto> getAllPosts(Integer pageSize, Integer pageNumber);

    Page<PostDto> getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String order);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostsByCategory(Integer categoryId);

    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> searchPostsByKeyword(String keyword);
}
