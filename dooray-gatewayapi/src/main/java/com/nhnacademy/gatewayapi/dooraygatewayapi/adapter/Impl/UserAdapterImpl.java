package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.UserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {

    private final RestTemplate restTemplate;

//    @Override
//    public List<UserDTO> getUserDTOS() {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
//        ResponseEntity<List<UserDTO>> exchange = restTemplate.exchange("http://localhost:9090/users",
//            HttpMethod.GET,
//            requestEntity,
//            new ParameterizedTypeReference<List<UserDTO>>() {
//            });
//        return exchange.getBody();
//    }


    @Override
    public String registerUser(UserDto userDto) {
        RequestEntity<UserDto> requestEntity = RequestEntity
            .post("http://localhost:9090/user/register")
            .accept(MediaType.APPLICATION_JSON)
            .body(userDto);

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity,
            new ParameterizedTypeReference<String>() {
            });

        return responseEntity.getBody();
    }

    @Override
    public UserDto getUser(String username) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<UserDto> exchange = restTemplate.exchange("http://localhost:9090/user/"+username,
            HttpMethod.GET,
            httpEntity,
            UserDto.class);

        return exchange.getBody();
    }
}
