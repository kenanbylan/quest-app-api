package com.springproject.QuestApp.repositorys;

import com.springproject.QuestApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
