package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.TaskAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskRegisterRequest;
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
public class TaskAdapterImpl implements TaskAdapter {

    private final RestTemplate restTemplate;

    @Override
    public List<TaskDto> getTaskDtosByProjectNo(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TaskDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/task/projectNo/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<TaskDto>>() {
            });
        return exchange.getBody();
    }

    @Override
    public void registerTask(TaskRegisterRequest request) {
        RequestEntity<TaskRegisterRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/task/register")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        restTemplate.exchange(requestEntity, new ParameterizedTypeReference<String>() {});
    }

    @Override
    public TaskDto getTaskDtoByTaskNo(Integer taskNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<TaskDto> exchange = restTemplate.exchange(
            "http://localhost:9091/task/taskNo/" + taskNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<TaskDto>() {
            });
        return exchange.getBody();
    }

    @Override
    public Integer modifyTask(TaskModifyRequest request) {
        RequestEntity<TaskModifyRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/task/modify")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        return restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Integer>() {}).getBody();
    }

    @Override
    public Integer deleteTask(Integer taskNo) {
        RequestEntity<Integer> requestEntity = RequestEntity
            .post("http://localhost:9091/task/delete")
            .accept(MediaType.APPLICATION_JSON)
            .body(taskNo);

        return restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Integer>() {}).getBody();
    }
}
