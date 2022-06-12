package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import java.util.List;

public interface TagService {

    List<TagDto> getTagDtoByProjectNo(Integer projectNo);
}
