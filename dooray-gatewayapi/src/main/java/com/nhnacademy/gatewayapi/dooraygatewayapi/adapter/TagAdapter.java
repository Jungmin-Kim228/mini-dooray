package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import java.util.List;

public interface TagAdapter {

    List<TagDto> getTagDtosByProjectNo(Integer projectNo);
}
