package com.nhnacademy.accountapi.doorayaccountapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String userEmail;

    private String userId;

    private String userPw;
}
