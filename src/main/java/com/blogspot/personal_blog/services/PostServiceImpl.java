package com.blogspot.personal_blog.services;

import com.blogspot.personal_blog.entities.Category;
import com.blogspot.personal_blog.entities.Post;
import com.blogspot.personal_blog.entities.User;
import com.blogspot.personal_blog.exceptions.ResourceNotFoundException;
import com.blogspot.personal_blog.payloads.PostDto;
import com.blogspot.personal_blog.repositories.CategoryRepository;
import com.blogspot.personal_blog.repositories.PostRepository;
import com.blogspot.personal_blog.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper,
                           UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setPostCreationDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(Integer postId, PostDto postDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));

        post.setPostTitle(postDto.getTitle());
        post.setPostContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = postRepository.save(post);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
        postRepository.delete(post);
    }

//    @Override
//    public List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize) {
//        // Subtract 1 from pageNumber because PageRequest is 0-indexed
//        Pageable page = PageRequest.of(pageNumber - 1, pageSize);
//        Page<Post> pageOfPosts = postRepository.findAll(page);
//        List<Post> allPosts = pageOfPosts.getContent();
//        return allPosts.stream().map((post) -> modelMapper.map(post, PostDto.class)).toList();
//    }

    @Override
    public Page<PostDto> getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        // Subtract 1 from pageNumber because PageRequest is 0-indexed
        Page<Post> pageOfPosts = postRepository.findAll(PageRequest.of(pageNumber - 1, pageSize, sort));
        return pageOfPosts.map((post) -> modelMapper.map(post, PostDto.class));
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        List<Post> listOfPostsByCategory = postRepository.findByCategory(category);
        return listOfPostsByCategory.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        List<Post> listOfPostsByUser = postRepository.findByUser(user);
        return listOfPostsByUser.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();
    }

    @Override
    public List<PostDto> searchPostsByKeyword(String keyword) {
        List<Post> postsByTitleContaining = postRepository.findByPostTitleContaining(keyword);
        return postsByTitleContaining.stream().map((post) -> modelMapper.map(post, PostDto.class)).toList();
    }
}
