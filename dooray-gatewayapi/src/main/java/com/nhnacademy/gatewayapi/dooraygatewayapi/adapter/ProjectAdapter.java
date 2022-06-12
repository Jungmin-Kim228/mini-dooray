package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectRequest;
import java.util.List;

public interface ProjectAdapter {

    List<ProjectDto> getOwnProjectDtoList(String userName);

    void registerProject(ProjectRequest projectRequest);

    ProjectDto getProjectDtoByProjectNo(Integer projectNo);
}
