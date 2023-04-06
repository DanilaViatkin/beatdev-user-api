package com.beatdev.api.controller;

import com.beatdev.core.model.User;
import com.beatdev.core.model.UserDto;
import com.beatdev.core.service.logic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findUserById(@PathVariable("id") long id){
        User user = userService.findUserById(id);
        return user;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createUser(@RequestBody UserDto userDto){
        return 10L;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<String> updateUserStatus(@RequestBody String status){
        return new ArrayList<>(Arrays.asList("Fuck", "Me"));
    }
}
