package com.springproject.QuestApp.services;

import com.springproject.QuestApp.entities.Post;
import com.springproject.QuestApp.entities.User;
import com.springproject.QuestApp.repositorys.PostRepository;
import com.springproject.QuestApp.repositorys.UserRepository;
import com.springproject.QuestApp.requests.PostCreateRequest;
import com.springproject.QuestApp.requests.PostUpdateRequest;
import com.springproject.QuestApp.responses.PostResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    PostRepository postRepository;
    UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }



    //Post listesini çektik ve PostResponse Modeline mapledik sonra bunu döndürdük.
    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> listPost;
            if (userId.isPresent()) {
                listPost = postRepository.findByUserId(userId.get());
            } else {
                listPost = postRepository.findAll();
            }
        return listPost.stream().map(post -> new PostResponse(post)).collect(Collectors.toList());
    }

    public Post getOnePostById(Long postId) {
        return  postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {

        User user = userService.getOneUserById(newPostRequest.getUserId());
        if(user == null) {
            return  null; // Exception
        }

        Post toSave = new Post(); //Yeni bir Post oluşturduk.

        toSave.setId(newPostRequest.getId());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setText(newPostRequest.getText());
        toSave.setUser(user);

        return postRepository.save(toSave);

    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) {
            Post toUpdate = post.get(); //idye göre biri varsa bilgileri alındı ve toUpdate'e atandı.
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
           return  toUpdate;
        }

        return  null;
    }

    public void deleteOnePostById(Long postId) {

        postRepository.deleteById(postId);
    }
}
