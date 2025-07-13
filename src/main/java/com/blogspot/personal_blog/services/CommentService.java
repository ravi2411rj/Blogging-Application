package com.blogspot.personal_blog.services;

import com.blogspot.personal_blog.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(Integer postId, CommentDto commentDto);

    void deleteComment(Integer commentId);

}
