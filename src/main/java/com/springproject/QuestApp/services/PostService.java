package com.springproject.QuestApp.services;

import com.springproject.QuestApp.entities.Post;
import com.springproject.QuestApp.entities.User;
import com.springproject.QuestApp.repositorys.PostRepository;
import com.springproject.QuestApp.repositorys.UserRepository;
import com.springproject.QuestApp.requests.PostCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<Post> getAllPosts(Optional<Long> userId) {
            if (userId.isPresent()) {
                return postRepository.findByUserId(userId.get());
            }

            return  postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return  postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        System.out.println("Çalıştı Service");
        User user = userService.getOneUser(newPostRequest.getUserId());

        System.out.println("user: " + user);

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
}
