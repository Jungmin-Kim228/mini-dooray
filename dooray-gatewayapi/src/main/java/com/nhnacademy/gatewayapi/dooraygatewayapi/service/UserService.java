package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserId;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserRequest;

public interface UserService {

    String registerUser(UserRequest userRequest);
}
