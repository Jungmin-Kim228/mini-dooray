package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserId;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public String registerUser(UserRequest userRequest) {
        RequestEntity<UserRequest> requestEntity = RequestEntity
            .post("http://localhost:9090/user/register")
            .accept(MediaType.APPLICATION_JSON)
            .body(userRequest);

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity,
            new ParameterizedTypeReference<String>() {
            });

        return responseEntity.getBody();
    }
    // here 여기서 account api 로 request를 보내면
    // here 가입 정보 저장 하고 userid 빼오기
}