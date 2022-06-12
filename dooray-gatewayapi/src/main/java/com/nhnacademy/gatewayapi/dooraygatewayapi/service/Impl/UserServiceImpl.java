package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.UserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAdapter userAdapter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserDto userDto) {
        userDto.setUserPw(passwordEncoder.encode(userDto.getUserPw()));
        return userAdapter.registerUser(userDto);
    }

    @Override
    public UserDto getUser(String username) {
        return userAdapter.getUser(username);
    }

    @Override
    public List<UserIdOnlyDto> getAllUserId() {
        return userAdapter.getAllUserId();
    }
}
