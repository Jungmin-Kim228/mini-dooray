package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagRegisterRequest;
import java.util.List;

public interface TagService {

    List<TagDto> getTagDtosByProjectNo(Integer projectNo);

    void registerTag(TagRegisterRequest request);
}
