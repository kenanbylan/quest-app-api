package com.springproject.QuestApp.repositorys;

import com.springproject.QuestApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByIdAndPostId(Long userId, Long postId);
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long postId);

}
