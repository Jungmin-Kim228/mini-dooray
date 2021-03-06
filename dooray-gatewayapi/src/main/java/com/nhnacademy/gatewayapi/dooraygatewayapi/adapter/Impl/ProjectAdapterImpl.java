package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.ProjectAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectRegisterRequest;
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
public class ProjectAdapterImpl implements ProjectAdapter {

    private final RestTemplate restTemplate;

    @Override
    public List<ProjectDto> getOwnProjectDtoList(String userName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/project/" + userName,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<ProjectDto>>() {
            });
        return exchange.getBody();
    }

    @Override
    public void registerProject(ProjectRegisterRequest projectRegisterRequest) {
        RequestEntity<ProjectRegisterRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/project/register")
            .accept(MediaType.APPLICATION_JSON)
            .body(projectRegisterRequest);

        restTemplate.exchange(requestEntity, new ParameterizedTypeReference<String>() {});
    }

    @Override
    public ProjectDto getProjectDtoByProjectNo(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(
            "http://localhost:9091/project/no/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<ProjectDto>() {
            });
        return exchange.getBody();
    }
}
