package com.nhnacademy.accountapi.doorayaccountapi.domain;

import lombok.Data;

@Data
public class UserRequest {

    private String userEmail;

    private String userId;

    private String userPw;
}
