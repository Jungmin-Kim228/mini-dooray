package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectRegisterRequest;
import java.util.List;

public interface ProjectAdapter {

    List<ProjectDto> getOwnProjectDtoList(String userName);

    void registerProject(ProjectRegisterRequest projectRegisterRequest);

    ProjectDto getProjectDtoByProjectNo(Integer projectNo);
}
