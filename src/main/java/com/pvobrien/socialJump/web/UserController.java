package com.pvobrien.socialJump.web;

import com.pvobrien.socialJump.domain.User;
import com.pvobrien.socialJump.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users") // best place to see this in console browser is via the network panel
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }
}
