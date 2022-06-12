package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.TagAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagAdapter tagAdapter;

    @Override
    public List<TagDto> getTagDtosByProjectNo(Integer projectNo) {
        return tagAdapter.getTagDtosByProjectNo(projectNo);
    }

    @Override
    public void registerTag(TagRegisterRequest request) {
        tagAdapter.registerTag(request);
    }

    @Override
    public Integer modifyTag(TagModifyRequest request) {
        return tagAdapter.modifyTag(request);
    }
}
