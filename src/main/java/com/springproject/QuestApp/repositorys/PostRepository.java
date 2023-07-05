package com.springproject.QuestApp.repositorys;

import com.springproject.QuestApp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserId(Long userId); //Bunu araştır.
}
