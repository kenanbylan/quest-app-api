package com.springproject.QuestApp.repositorys;

import com.springproject.QuestApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
