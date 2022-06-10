package com.nhnacademy.accountapi.doorayaccountapi.service;

import com.nhnacademy.accountapi.doorayaccountapi.domain.UserRequest;

public interface UserService {

    Integer registerUser(UserRequest userRequest);
}
