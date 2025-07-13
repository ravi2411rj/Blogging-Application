package com.blogspot.personal_blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be at least 4 characters long.")
    private String name;

    @Email(message = "Email address is not valid.")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be 3 - 10 characters long.")
    private String password;

    @NotEmpty(message = "About field must not be empty.")
    private String about;
}
