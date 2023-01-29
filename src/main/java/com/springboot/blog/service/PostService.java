package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    PostDto updatePostById(Long id, PostDto postDto);

    void deleteById(Long id);

}