package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import java.util.List;

public interface ProjectUserAdapter {

    List<ProjectUserDto> getProjectUserDtoByProjectNo(Integer projectNo);
}
