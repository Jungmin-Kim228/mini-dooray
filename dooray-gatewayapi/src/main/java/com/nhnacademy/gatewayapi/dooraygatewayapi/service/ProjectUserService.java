package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import java.util.List;

public interface ProjectUserService {

    List<ProjectUserDto> getProjectUserDtosByProjectNo(Integer projectNo);
}
