package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import java.util.List;

public interface TagService {

    List<TagDto> getTagByProjectNo(Integer no);
}
