package com.example.blogApplication.Payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;

@Data
public class CommentDto {
    private long id;

    @NotEmpty(message = "name should not be null or empty")
    private String name;

    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;

    @NotEmpty
    @Min(value = 10, message = "minimum 10 characters")
    private String body;
}
