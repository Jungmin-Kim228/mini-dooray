package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.UserIdOnlyDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProjectUserRepositoryCustom {

    List<ProjectUserDto> getProjectUserByProjectNo(Integer no);

    List<UserIdOnlyDto> getProjectUserIdsByProjectNo(Integer no);
}
