package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TagRepositoryCustom {

    List<TagDto> getTagsByProjectNo(Integer no);

    List<TagDto> getTagDtosByTaskNo(Integer taskNo);
}
