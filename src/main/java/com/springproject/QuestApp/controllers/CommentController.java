package com.springproject.QuestApp.controllers;


import com.springproject.QuestApp.entities.Comment;
import com.springproject.QuestApp.requests.CommentCreateRequest;
import com.springproject.QuestApp.requests.CommentUpdateRequest;
import com.springproject.QuestApp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return  commentService.getAllCommentWithParam(userId,postId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request) {
        return  commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return  commentService.getOneCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return  commentService.updateOneCommentById(commentId,commentUpdateRequest);
    }

    @DeleteMapping("/{commentId}")
    public  void  deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }



}
