package com.example.blogApplication.Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class BlogApiException extends RuntimeException {

//    private HttpStatus httpStatus;
    private HttpStatusCode httpStatusCode;
    private String message;

    public BlogApiException(HttpStatus httpStatusCode, String message) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }
}
