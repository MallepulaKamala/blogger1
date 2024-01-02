package com.blog.controller;


import com.blog.Service.CommentService;
import com.blog.playload.CommentDto;
import com.blog.playload.PostDto;
import com.blog.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam("postId")long postId, @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("comment is deleted!!",HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable long postId){
        List<CommentDto> commentDto = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }
    //http://localhost:8080/api/comments?commentId=1
    @PutMapping
   public ResponseEntity<CommentDto> updateComment(@RequestParam("commentId")long commentId,@RequestBody CommentDto commentDto){
        CommentDto dto = commentService.updatecomment(commentId, commentDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

@GetMapping
    public ResponseEntity<List<CommentDto>>

getAllComments(){
        List<CommentDto> commentDtos = commentService.getAllComments();
        return new ResponseEntity<>(commentDtos,HttpStatus.OK);
    }

}
