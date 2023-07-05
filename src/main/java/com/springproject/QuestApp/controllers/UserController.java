package com.springproject.QuestApp.controllers;


import com.springproject.QuestApp.entities.User;
import com.springproject.QuestApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")  //Bu classtaki tüm endpointlerin başında /user var olacağını belirtik.
public class UserController {


    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUsers() {
       return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser ) {
        return  userService.saveOneUser(newUser);
    }


    @GetMapping("/{userId}")
    public User getUserbyId(@PathVariable Long userId) {
        return  userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
       return  userService.updateOneUser(userId,newUser);
    }


    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }

}
