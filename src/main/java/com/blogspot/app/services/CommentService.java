package com.blogspot.app.services;

import com.blogspot.app.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(Integer postId, CommentDto commentDto);

    void deleteComment(Integer commentId);

}
