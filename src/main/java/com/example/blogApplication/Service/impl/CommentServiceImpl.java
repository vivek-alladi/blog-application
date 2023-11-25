package com.example.blogApplication.Service.impl;

import com.example.blogApplication.Entity.Comment;
import com.example.blogApplication.Entity.Post;
import com.example.blogApplication.Exceptions.BlogApiException;
import com.example.blogApplication.Exceptions.ResourceNotFoundException;
import com.example.blogApplication.Payload.CommentDto;
import com.example.blogApplication.Repository.CommentRepository;
import com.example.blogApplication.Repository.PostRepository;
import com.example.blogApplication.Service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId));
        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);

        return mapToDto(comment);
    }

    @Override
    public List<CommentDto> getAllCommentsForPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream().map((comment -> mapToDto(comment))).toList();
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) throws BlogApiException{
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(postId)) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return mapToDto(comment);
    }

    @Override
    public CommentDto updateCommentById(long postId, long commentId, CommentDto commentDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(postId)) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(comment.getBody());

        return mapToDto(commentRepository.save(comment));
    }

    @Override
    public void deleteCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(postId)) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        commentRepository.delete(comment);
    }


    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        return comment;
    }
}
