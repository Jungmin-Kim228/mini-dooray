package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagRegisterRequest;
import java.util.List;

public interface TagAdapter {

    List<TagDto> getTagDtosByProjectNo(Integer projectNo);

    void registerTag(TagRegisterRequest request);

    Integer modifyTag(TagModifyRequest request);

    Integer deleteTag(Integer tagNo);

    List<TagDto> getTagDtosByTaskNo(Integer taskNo);
}
