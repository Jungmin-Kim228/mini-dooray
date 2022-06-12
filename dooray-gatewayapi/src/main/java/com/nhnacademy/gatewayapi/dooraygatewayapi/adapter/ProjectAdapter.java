package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import java.util.List;

public interface ProjectAdapter {

    List<ProjectDto> getOwnProjectDtoList(String userName);

    void registerProject(ProjectDto projectDto);
}
