package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import java.util.List;

public interface UserService {

    String registerUser(UserDto userDto);

    UserDto getUser(String username);

    List<ProjectUserDto> getAllUserId();
}
