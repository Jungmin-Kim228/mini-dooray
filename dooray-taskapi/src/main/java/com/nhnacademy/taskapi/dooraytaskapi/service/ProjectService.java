package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRegisterRequest;
import java.util.List;

public interface ProjectService {

    List<ProjectDto> getOwnProjects(String id);

    void registerProject(ProjectRegisterRequest request);

    ProjectDto getProjectDtoByProjectNo(Integer no);
}
