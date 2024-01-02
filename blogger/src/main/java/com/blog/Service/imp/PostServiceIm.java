package com.blog.Service.imp;

import com.blog.entity.post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.playload.PostDto;
import com.blog.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceIm implements Postservice {
    private PostRepository postRepo;

    public PostServiceIm(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

//    @Override
//    public void createPost(PostDto postDto) {
//        post post=new post();
//
//
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
//
//        postRepo.save(post);

    @Override
    public PostDto createPost(PostDto postDto) {
        post post = new post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        post savedPost = postRepo.save(post);

        PostDto dto = new PostDto();
        dto.setId(savedPost.getId());
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());


        return dto;


    }

    @Override
    public void deletePost(long id) {
       post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id:" + id)
        );

        postRepo.deleteById(id);
    }

   @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
       Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
       Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
       Page<post> pageposts = postRepo.findAll(pageable);
       List<post> posts = pageposts.getContent();
       List<PostDto> dtos = posts.stream().map(p -> (mapToDto(p))).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public PostDto updatepost(long postId, PostDto postDto) {
        post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post Not Found with Id:" +postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post savedpost = postRepo.save(post);
        PostDto dto = mapToDto(savedpost);
        return dto;
    }

    PostDto mapToDto(post post){
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }


}
