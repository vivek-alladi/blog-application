package com.example.blogApplication.Service;

import com.example.blogApplication.Payload.PostDto;
import com.example.blogApplication.Payload.PostResponse;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    String deletePost(long id);
}
