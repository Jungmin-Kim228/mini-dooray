package com.nhnacademy.accountapi.doorayaccountapi.service;

import com.nhnacademy.accountapi.doorayaccountapi.domain.UserDto;
import com.nhnacademy.accountapi.doorayaccountapi.domain.UserIdOnlyDto;
import com.nhnacademy.accountapi.doorayaccountapi.domain.UserRequest;
import java.util.List;

public interface UserService {

    String registerUser(UserRequest userRequest);

    UserDto getUser(String id);

    List<UserIdOnlyDto> getAllUserId();
}
