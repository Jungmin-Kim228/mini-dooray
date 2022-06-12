package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
import java.util.List;

public interface UserAdapter {

//    List<UserDTO> getUserDTOS();

    String registerUser(UserDto userDto);

    UserDto getUser(String username);

    List<UserIdOnlyDto> getAllUserId();
}
