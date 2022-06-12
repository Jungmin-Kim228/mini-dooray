package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRegisterRequest;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProjectRepositoryCustom {

    List<ProjectDto> getOwnProjects(String id);

    ProjectDto getProjectDtoByProjectNo(Integer no);
}
