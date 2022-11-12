package com.authentication.controllers;

import com.authentication.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    /**
     * return user resource
     * @param userId
     * @return User
     */
    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") String userId){
        return new User(userId, "Denes", "Vaghani");
    }
}
