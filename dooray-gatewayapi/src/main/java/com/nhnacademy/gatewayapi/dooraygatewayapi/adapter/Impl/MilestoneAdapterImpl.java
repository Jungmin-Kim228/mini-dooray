package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.MilestoneAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneRegisterRequest;
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
public class MilestoneAdapterImpl implements MilestoneAdapter {

    private final RestTemplate restTemplate;

    @Override
    public List<MilestoneDto> getMilestoneDtosByProjectNo(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<MilestoneDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/milestone/projectNo/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<MilestoneDto>>() {
            });
        return exchange.getBody();
    }

    @Override
    public void registerMilestone(MilestoneRegisterRequest request) {
        RequestEntity<MilestoneRegisterRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/milestone/register")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        restTemplate.exchange(requestEntity, new ParameterizedTypeReference<String>() {});
    }

    @Override
    public Integer modifyMilestone(MilestoneModifyRequest request) {
        RequestEntity<MilestoneModifyRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/milestone/modify")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        return restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Integer>() {}).getBody();
    }

    @Override
    public Integer deleteMilestone(Integer milestoneNo) {
        RequestEntity<Integer> requestEntity = RequestEntity
            .post("http://localhost:9091/milestone/delete")
            .accept(MediaType.APPLICATION_JSON)
            .body(milestoneNo);

        return restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Integer>() {}).getBody();
    }

    @Override
    public MilestoneDto getMilestoneDtoByTaskNoAndProjectNo(Integer taskNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<MilestoneDto> exchange = restTemplate.exchange(
            "http://localhost:9091/milestone/taskNo/"+taskNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<MilestoneDto>() {
            });
        return exchange.getBody();
    }
}
