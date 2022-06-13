package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserAddRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.UserIdOnlyDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.ProjectUser;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectUserNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectUserRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.ProjectUserService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;

    @Override
    public List<ProjectUserDto> getProjectUserByProjectNo(Integer no) {
        return projectUserRepository.getProjectUserByProjectNo(no);
    }

    @Override
    public List<UserIdOnlyDto> getProjectUserIdByProjectNo(Integer no) {
        return projectUserRepository.getProjectUserIdsByProjectNo(no);
    }

    @Override
    public void addProjectUser(ProjectUserAddRequest request) {
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(
            ProjectNotFoundException::new);
        for (String userId : request.getUserIdList()) {
            ProjectUser projectUser = ProjectUser
                .addProjectUser()
                .id(userId)
                .project(project)
                .build();
            projectUserRepository.save(projectUser);
        }
    }

    @Override
    public void deleteProjectUser(ProjectUserDeleteRequest request) {
        ProjectUser projectUser = projectUserRepository.findById(new ProjectUser.Pk(
            request.getUserId(), request.getProjectNo())).orElseThrow(ProjectUserNotFoundException::new);
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(ProjectNotFoundException::new);
        if (Objects.equals(project.getAdminId(), request.getUserId())) {
            return;
        }
        projectUserRepository.delete(projectUser);
    }
}
