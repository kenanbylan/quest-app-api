package com.springproject.QuestApp.controllers;


import com.springproject.QuestApp.entities.User;
import com.springproject.QuestApp.repositorys.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")  //Bu classtaki tüm endpointlerin başında /user var olacağını belirtik.
public class UserController {

    private UserRepository userRepository; //Contructor injection ile enjekte edilir.

    //Sanki user-controller oluşturuldan userRepository ekleniyormuş gibi yapıyoruz.
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser ) {
        return  userRepository.save(newUser);
    }


    @GetMapping("/{userId}")
    public User getUserbyId(@PathVariable Long userId) {
        //BU ıd'ye ait biri var mı database bakmak gerekiyor bir throws oluşturmak lazım.
        return  userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
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


    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
          userRepository.deleteById(userId);

    }

}
