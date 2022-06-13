package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserAddRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
import java.util.List;

public interface ProjectUserAdapter {

    List<ProjectUserDto> getProjectUserDtosByProjectNo(Integer projectNo);

    void addProjectUser(ProjectUserAddRequest request);

    void deleteProjectUser(ProjectUserDeleteRequest request);
}
