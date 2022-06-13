package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.ProjectUserAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserAddRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
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

    @Override
    public List<ProjectUserDto> excludeMember(List<ProjectUserDto> allUserIds, Integer projectNo) {
        List<ProjectUserDto> memberIds = projectUserAdapter.getProjectUserDtosByProjectNo(projectNo);
        for (ProjectUserDto member : memberIds) {
            allUserIds.remove(member);
        }
        return allUserIds;
    }

    @Override
    public void addProjectUser(ProjectUserAddRequest request) {
        projectUserAdapter.addProjectUser(request);
    }

    @Override
    public void deleteProjectUser(ProjectUserDeleteRequest request) {
        projectUserAdapter.deleteProjectUser(request);
    }
}
