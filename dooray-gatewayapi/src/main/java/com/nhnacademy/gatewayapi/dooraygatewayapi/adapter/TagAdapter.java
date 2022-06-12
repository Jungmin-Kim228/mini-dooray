package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import java.util.List;

public interface TagAdapter {

    List<TagDto> getTagDtoByProjectNo(Integer projectNo);
}
