package com.blog.controller;

import com.blog.Service.imp.Postservice;
import com.blog.entity.post;
import com.blog.playload.PostDto;
import com.blog.repository.PostRepository;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private Postservice postservice;

    public PostController(Postservice postservice) {
        this.postservice = postservice;
    }




//@PreAuthorize("hashRole('ADMIN')")
    @PostMapping
        public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PostDto dto=postservice.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @PreAuthorize("hashRole('ADMIN')")
    @DeleteMapping("/{id}")
        public ResponseEntity<String> deletePost ( @PathVariable long id){
            postservice.deletePost(id);
            return new ResponseEntity<>("post deleted!!", HttpStatus.OK);

        }
    //http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto>getAllPosts(@RequestParam(name="pageNo",defaultValue = "0",required = false)int pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "3",required = false)int pageSize,
                                    @RequestParam(name = "sortBy" ,defaultValue = "id",required = false)String sortBy,
                                    @RequestParam(name = "sortDir" ,defaultValue = "asc",required = false)String sortDir){


        List<PostDto> postDtos = postservice.getAllPosts(pageNo, pageSize,sortBy,sortDir);
        return postDtos;
    }

    //http://localhost:8080/api/posts?postId=8
    @PreAuthorize("hashRole('ADMIN')")
    @PutMapping
    public ResponseEntity<PostDto> updatepost(@RequestParam("postId") long postId,@RequestBody PostDto postDto){
        PostDto dto = postservice.updatepost(postId, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    }
