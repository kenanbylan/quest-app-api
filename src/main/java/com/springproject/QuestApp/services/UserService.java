package com.springproject.QuestApp.services;

import com.springproject.QuestApp.entities.User;
import com.springproject.QuestApp.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return  userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
            //custom exception.
        return  userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) { //obje var ise

            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());

            userRepository.save(foundUser);
            return  foundUser;
        } else  {
            return  null; //Custom Exception.
        }

    }

    public void deleteById(Long userId) {
         userRepository.deleteById(userId);
    }
}
