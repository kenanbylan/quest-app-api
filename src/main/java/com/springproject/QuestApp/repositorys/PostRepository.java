package com.springproject.QuestApp.repositorys;

import com.springproject.QuestApp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
