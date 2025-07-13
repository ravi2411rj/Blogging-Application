package com.blogspot.personal_blog.payloads;

import com.blogspot.personal_blog.entities.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;

    @NotEmpty
    @Size(min = 4, message = "Post title must be at least 4 characters long.")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post content must be at least 10 characters long.")
    private String content;

    private String imageName;

    private Date creationDate;

    private CategoryDto category;

    private UserDto user;

    private List<CommentDto> comments = new ArrayList<>();

}
