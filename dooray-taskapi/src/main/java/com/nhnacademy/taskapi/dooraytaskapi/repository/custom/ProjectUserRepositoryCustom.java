package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProjectUserRepositoryCustom {

    List<ProjectUserDto> getProjectUserByProjectNo(Integer no);
}
