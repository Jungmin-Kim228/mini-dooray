package com.nhnacademy.accountapi.doorayaccountapi.service;

import com.nhnacademy.accountapi.doorayaccountapi.domain.UserDto;
import com.nhnacademy.accountapi.doorayaccountapi.domain.UserRequest;
import com.nhnacademy.accountapi.doorayaccountapi.entity.User;
import com.nhnacademy.accountapi.doorayaccountapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public String registerUser(UserRequest userRequest) {
        User user = User.addUser()
            .email(userRequest.getUserEmail())
            .id(userRequest.getUserId())
            .pw(userRequest.getUserPw())
            .build();
        userRepository.save(user);
        return user.getUserId();
    }

    @Override
    public UserDto getUser(String id) {
        return userRepository.getUserDtoByUserId(id);
    }
}
