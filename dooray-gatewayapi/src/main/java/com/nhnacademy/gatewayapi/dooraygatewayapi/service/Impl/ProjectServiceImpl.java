package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.ProjectAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectAdapter projectAdapter;

    @Override
    public List<ProjectDto> getOwnProject(String userName) {
        return projectAdapter.getOwnProjectDtoList(userName);
    }

    @Override
    public void registerProject(ProjectRequest projectRequest) {
        projectAdapter.registerProject(projectRequest);
    }

    @Override
    public String getProjectNameByNo(Integer projectNo) {
        return projectAdapter.getProjectNameByNo(projectNo);
    }
}
