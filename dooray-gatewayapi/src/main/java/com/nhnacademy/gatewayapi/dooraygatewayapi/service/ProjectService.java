package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectRegisterRequest;
import java.util.List;

public interface ProjectService {

    List<ProjectDto> getOwnProject(String userName);

    void registerProject(ProjectRegisterRequest projectRegisterRequest);

    ProjectDto getProjectDtoByProjectNo(Integer projectNo);
}
