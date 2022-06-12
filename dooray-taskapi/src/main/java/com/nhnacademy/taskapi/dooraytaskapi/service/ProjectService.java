package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRequest;
import java.util.List;

public interface ProjectService {

    List<ProjectDto> getOwnProjects(String id);

    ProjectRequest registerProject(ProjectRequest projectRequest);

    String getProjectNameByNo(Integer no);
}
