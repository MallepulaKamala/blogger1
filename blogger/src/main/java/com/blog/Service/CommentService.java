package com.blog.Service;


import com.blog.playload.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto createComment(long postId, CommentDto commentDto);

    void deleteComment(long commentId);

    List<CommentDto> getCommentsByPostId(long postId);


    CommentDto updatecomment(long commentId, CommentDto commentDto);

    List<CommentDto> getAllComments();
}

