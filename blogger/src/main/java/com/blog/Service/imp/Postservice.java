package com.blog.Service.imp;

import com.blog.playload.PostDto;

import java.util.List;

public interface Postservice {
//    public void createPost(PostDto postDto);

    public PostDto createPost(PostDto postDto);

     public void deletePost(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updatepost(long postId, PostDto postDto);


    //List<PostDto> getAllPosts(int pageNo,int pageSize);
}
