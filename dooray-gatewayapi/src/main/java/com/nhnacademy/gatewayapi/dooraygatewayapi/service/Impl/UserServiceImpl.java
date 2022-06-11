package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.UserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserId;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAdapter userAdapter;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserRequest userRequest) {
//        userRequest.setUserPw(passwordEncoder.encode(userRequest.getUserPw()));
        return userAdapter.registerUser(userRequest);
    }
}
