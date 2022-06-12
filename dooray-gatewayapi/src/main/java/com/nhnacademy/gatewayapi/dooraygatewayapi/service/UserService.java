package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
import java.util.List;

public interface UserService {

    String registerUser(UserDto userDto);

    UserDto getUser(String username);

    List<UserIdOnlyDto> getAllUserId();
}
