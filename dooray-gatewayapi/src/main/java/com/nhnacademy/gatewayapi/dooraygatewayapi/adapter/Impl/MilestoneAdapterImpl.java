package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.MilestoneAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
            "http://localhost:9091/milestone/no/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<MilestoneDto>>() {
            });
        return exchange.getBody();
    }
}
