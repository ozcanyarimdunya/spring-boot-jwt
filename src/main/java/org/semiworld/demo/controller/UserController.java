package org.semiworld.demo.controller;

import org.semiworld.demo.model.ApplicationUser;
import org.semiworld.demo.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ApplicationUserService applicationUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(ApplicationUserService applicationUserService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserService = applicationUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserService.save(user);
    }
}
