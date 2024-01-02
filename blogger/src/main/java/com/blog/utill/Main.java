package com.blog.utill;

import com.blog.Mainutil1;
import com.blog.post;
import com.blog.postDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        //by using method reference
        Main main=new Main();
        post post1 = new post();
        post1.setId(1);
        post1.setTitle("kamal");
        post1.setContent("kamalaaa");

        post post2 = new post();
        post2.setId(2);
        post2.setTitle("sowji");
        post2.setContent("sowjiii");

        post post3 = new post();
        post3.setId(3);
        post3.setTitle("cintu");
        post3.setContent("cintuuu");
//calling a method by using method reference
        List<post> posts= Arrays.asList(post1,post2,post3);
        //calling a method
        List<postDto> dto=posts.stream().map(main::mapToDto).collect(Collectors.toList());
        System.out.println(dto);
    }

     postDto mapToDto(post post) {
        postDto dto = new postDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;

    }

}
