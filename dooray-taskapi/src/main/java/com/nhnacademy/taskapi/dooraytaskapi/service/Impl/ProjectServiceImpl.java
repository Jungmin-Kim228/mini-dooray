package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.ProjectUser;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectUserRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;

    @Override
    public List<ProjectDto> getOwnProjects(String id) {
        return projectRepository.getOwnProjects(id);
    }

    @Override
    public ProjectRequest registerProject(ProjectRequest projectRequest) {
        Project project = Project.addProject()
                                 .name(projectRequest.getProjectName())
                                 .admin(projectRequest.getAdminId())
                                 .status(projectRequest.getProjectStatus())
                                 .build();
        projectRepository.save(project);
        ProjectUser projectUser = ProjectUser.addProjectUser()
                                             .project(project)
                                             .id(project.getAdminId())
                                             .build();
        projectUserRepository.save(projectUser);
        return projectRepository.getProjectDtoByProjectNo(project.getProjectNo());
    }

    @Override
    public String getProjectNameByNo(Integer no) {
        return projectRepository.getProjectNameByProjectNo(no);
    }
}
