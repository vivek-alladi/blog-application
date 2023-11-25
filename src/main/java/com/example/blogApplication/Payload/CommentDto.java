package com.example.blogApplication.Payload;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
