package com.springproject.QuestApp.controllers;

import com.springproject.QuestApp.entities.Post;
import com.springproject.QuestApp.requests.PostCreateRequest;
import com.springproject.QuestApp.requests.PostUpdateRequest;
import com.springproject.QuestApp.responses.PostResponse;
import com.springproject.QuestApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        System.out.println("Çalıştı endpoint");
        return postService.createOnePost(newPostRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId) {
        return  postService.getOnePostById(postId);
    }


    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return  postService.updateOnePostById(postId,updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId ) {
        postService.deleteOnePostById(postId);
    }

}
