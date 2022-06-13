package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagRegisterRequest;
import java.util.List;

public interface TagService {

    List<TagDto> getTagByProjectNo(Integer no);

    void registerTag(TagRegisterRequest request);

    Integer modifyTag(TagModifyRequest request);

    Integer deleteTag(Integer request);

    List<TagDto> getTagDtosByTaskNo(Integer taskNo);
}
