package com.example.blogApplication.Payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Post title should have min 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description should have min 10 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
