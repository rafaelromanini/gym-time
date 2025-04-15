package br.com.fiap.gym_time.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gym_time.models.Post;

@RestController
public class PostController {

    // List of all posts
    private List<Post> posts = new ArrayList<>();

    // Get all posts
    @GetMapping("/posts")
    public List<Post> getPosts() {
        return posts;
    }

    // Create a new post
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        System.out.println(("Creating post by " + post.getAccount()));
        posts.add(post);
        return ResponseEntity.status(201).body(post);
    }

    // Get details of a post
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        var post = posts
        .stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();

        if(post.isEmpty()){
            System.out.println("Post not found");
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(post.get());
    }

    // Delete a post
    @PostMapping("/posts/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        var post = posts
        .stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();

        if(post.isEmpty()){
            System.out.println("Post not found");
            return ResponseEntity.notFound().build(); 
        }

        posts.remove(post.get());
        return ResponseEntity.ok(post.get());
    }    
}
