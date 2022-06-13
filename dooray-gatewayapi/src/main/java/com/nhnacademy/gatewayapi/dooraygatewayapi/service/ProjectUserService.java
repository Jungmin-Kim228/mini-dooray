package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserAddRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
import java.util.List;

public interface ProjectUserService {

    List<ProjectUserDto> getProjectUserDtosByProjectNo(Integer projectNo);

    List<UserIdOnlyDto> excludeMember(List<UserIdOnlyDto> allUserIds, Integer projectNo);

    void addProjectUser(ProjectUserAddRequest request);
}
