package com.ark.arkbackendrediscache.controller;

import com.ark.arkbackendrediscache.model.User;
import com.ark.arkbackendrediscache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public void UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") String id,
                    @PathVariable("name") String name){
        userRepository.save(new User(id,name,2000L));
        return userRepository.findById(id);

    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") String id,
                    @PathVariable("name") String name){
        userRepository.save(new User(id,name,3000L));
        return userRepository.findById(id);

    }

    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") String id){
        userRepository.delete(id);
        return findAll();

    }

    @GetMapping("/all")
    public Map<String,User> findAll(){

        return userRepository.findAll();

    }
}
