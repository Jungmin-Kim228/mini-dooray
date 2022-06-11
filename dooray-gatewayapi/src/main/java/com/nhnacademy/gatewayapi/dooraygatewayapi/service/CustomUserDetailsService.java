package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.UserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAdapter userAdapter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userAdapter.getUser(username);

        return new User(user.getUserId(), user.getUserPw(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER")));

    }
}
