package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRequest;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProjectRepositoryCustom {

    List<ProjectDto> getOwnProjects(String id);

    ProjectRequest getProjectDtoByProjectNo(Integer projectNo);
}
