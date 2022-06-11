package com.nhnacademy.accountapi.doorayaccountapi.controller;

import com.nhnacademy.accountapi.doorayaccountapi.domain.UserDto;
import com.nhnacademy.accountapi.doorayaccountapi.domain.UserRequest;
import com.nhnacademy.accountapi.doorayaccountapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }
}
