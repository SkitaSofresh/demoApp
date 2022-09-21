package com.conversate.demoApp.controller;

import com.conversate.demoApp.entity.Post;
import com.conversate.demoApp.entity.User;
import com.conversate.demoApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PostMapping("/posts")
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }


    @PutMapping("/posts/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable Long id) {

        return postService.updatePost(id,post);
    }

    @DeleteMapping("post/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
