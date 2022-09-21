package com.conversate.demoApp.service;


import com.conversate.demoApp.entity.Post;
import com.conversate.demoApp.entity.User;
import com.conversate.demoApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingPost.setPostdate(post.getPostdate());
        existingPost.setUser(post.getUser());
        existingPost.setDetails(post.getDetails());

        postRepository.save(existingPost);
        return existingPost;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
