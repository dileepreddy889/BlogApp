package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //Create blog post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<PostDto> getPostByIt(@PathVariable("id") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<PostDto> updatePostByIt(@PathVariable Long id,@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.updatePostById(id, postDto),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}/")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        postService.deleteById(id);
        return new ResponseEntity<>("post entity deleted sucessfully",HttpStatus.OK);
    }
}
