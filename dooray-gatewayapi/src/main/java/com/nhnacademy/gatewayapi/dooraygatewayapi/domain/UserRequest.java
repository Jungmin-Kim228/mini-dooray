package com.nhnacademy.gatewayapi.dooraygatewayapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String email;

    private String id;

    private String pw;
}
