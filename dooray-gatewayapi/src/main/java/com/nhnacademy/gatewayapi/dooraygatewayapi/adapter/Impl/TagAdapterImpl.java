package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.TagAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.DeleteRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagRegisterRequest;
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
public class TagAdapterImpl implements TagAdapter {

    private final RestTemplate restTemplate;

    @Override
    public List<TagDto> getTagDtosByProjectNo(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TagDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/tag/projectNo/" + projectNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<TagDto>>() {
            });
        return exchange.getBody();
    }

    @Override
    public void registerTag(TagRegisterRequest request) {
        RequestEntity<TagRegisterRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/tag/register")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        restTemplate.exchange(requestEntity, new ParameterizedTypeReference<String>() {});
    }

    @Override
    public Integer modifyTag(TagModifyRequest request) {
        RequestEntity<TagModifyRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/tag/modify")
            .accept(MediaType.APPLICATION_JSON)
            .body(request);

        return restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Integer>() {}).getBody();
    }

    @Override
    public Integer deleteTag(Integer tagNo) {
        RequestEntity<DeleteRequest> requestEntity = RequestEntity
            .post("http://localhost:9091/tag/delete")
            .accept(MediaType.APPLICATION_JSON)
            .body(new DeleteRequest(tagNo));

        return restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Integer>() {}).getBody();
    }

    @Override
    public List<TagDto> getTagDtosByTaskNo(Integer taskNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TagDto>> exchange = restTemplate.exchange(
            "http://localhost:9091/tag/taskNo/" + taskNo,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<TagDto>>() {
            });
        return exchange.getBody();
    }
}
