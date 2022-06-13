package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserAddRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import java.util.List;

public interface ProjectUserService {

    List<ProjectUserDto> getProjectUserDtosByProjectNo(Integer projectNo);

    List<ProjectUserDto> excludeMember(List<ProjectUserDto> allUserIds, Integer projectNo);

    void addProjectUser(ProjectUserAddRequest request);

    void deleteProjectUser(ProjectUserDeleteRequest request);
}
