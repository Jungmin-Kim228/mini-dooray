package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserId;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserRequest;

public interface UserAdapter {

//    List<UserDTO> getUserDTOS();

    String registerUser(UserRequest userRequest);
}
