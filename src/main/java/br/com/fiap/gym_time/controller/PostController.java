package br.com.fiap.gym_time.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.gym_time.models.Post;

@RestController
@RequestMapping("/posts")
public class PostController {

    private Logger log = LoggerFactory.getLogger(getClass());
    // List of all posts
    private List<Post> posts = new ArrayList<>();

    // Get all posts
    @GetMapping()
    public List<Post> getPosts() {
        return posts;
    }
    
    // Create a new post
    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        log.info("Posting...");
        posts.add(post);
        return ResponseEntity.status(201).body(post);
    }
    
    // Get details of a post
    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable Long id) {
        log.info("Searching post " + id);
        return getPost(id);
    }

    // Delete a post
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        log.info("Deleting post " + id);
        posts.remove(getPost(id));
    }    

    // Update a post
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        log.info("Updating post " + id);
        posts.remove(getPost(id));
        post.setId(id);
        posts.add(post);
    }

    private Post getPost(Long id) {
        return posts
            .stream()
            .filter(p -> p.getId().equals(id)) 
            .findFirst()
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
            );

    }
}
