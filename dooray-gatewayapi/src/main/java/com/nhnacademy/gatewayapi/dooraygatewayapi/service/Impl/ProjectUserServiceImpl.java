package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.ProjectUserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectUserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserAdapter projectUserAdapter;

    @Override
    public List<ProjectUserDto> getProjectUserDtosByProjectNo(Integer projectNo) {
        return projectUserAdapter.getProjectUserDtosByProjectNo(projectNo);
    }
}
