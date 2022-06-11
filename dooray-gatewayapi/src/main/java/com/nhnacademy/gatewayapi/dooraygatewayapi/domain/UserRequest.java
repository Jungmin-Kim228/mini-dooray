package com.nhnacademy.gatewayapi.dooraygatewayapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {

    private String userEmail;

    private String userId;

    private String userPw;
}