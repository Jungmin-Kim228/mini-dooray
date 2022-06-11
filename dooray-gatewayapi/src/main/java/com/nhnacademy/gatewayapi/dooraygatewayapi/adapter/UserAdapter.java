package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;

public interface UserAdapter {

//    List<UserDTO> getUserDTOS();

    String registerUser(UserDto userDto);

    UserDto getUser(String username);
}
