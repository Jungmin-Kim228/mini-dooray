package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import java.util.List;

public interface UserAdapter {

    String registerUser(UserDto userDto);

    UserDto getUser(String username);

    List<ProjectUserDto> getAllUserId();
}
