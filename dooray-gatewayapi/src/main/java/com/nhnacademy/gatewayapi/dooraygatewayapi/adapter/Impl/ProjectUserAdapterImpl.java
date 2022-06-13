package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.ProjectUserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserAddRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
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
public class ProjectUserAdapterImpl implements ProjectUserAdapter {

    private final RestTemplate restTemplate;

    @Override
    public List<ProjectUserDto> getProjectUserDtosByProjectNo(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectUserDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/projectUser/no/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<ProjectUserDto>>() {
            });
        return exchange.getBody();
    }

    @Override
    public List<UserIdOnlyDto> getProjectUserId(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<UserIdOnlyDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/projectUser/id/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<UserIdOnlyDto>>() {
            });
        return exchange.getBody();
    }

    @Override
    public void addProjectUser(ProjectUserAddRequest request) {
        RequestEntity<ProjectUserAddRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/projectUser/add")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        restTemplate.exchange(requestEntity, new ParameterizedTypeReference<String>() {});
    }
}
