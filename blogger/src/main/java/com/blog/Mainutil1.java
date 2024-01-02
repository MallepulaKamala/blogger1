package com.blog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mainutil1 {
    public static void main(String[] args) {
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

        List<post> posts= Arrays.asList(post1,post2,post3);
        List<postDto> dto=posts.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        System.out.println(dto);
    }

    static postDto mapToDto(post post) {
        postDto dto = new postDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());return dto;

    }
}
