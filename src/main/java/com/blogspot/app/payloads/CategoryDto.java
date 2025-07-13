package com.blogspot.app.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(min = 4, message = "Category title should contain at least 4 characters.")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10, message = "Category description should contain at least 4 characters.")
    private String categoryDescription;
}
