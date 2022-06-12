package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{id}")
    public List<ProjectDto> getOwnProjects(@PathVariable("id") String id) {
        return projectService.getOwnProjects(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerProject(@RequestBody ProjectRegisterRequest request) {
        projectService.registerProject(request);
    }

    @GetMapping("/no/{projectNo}")
    public ProjectDto getProjectDtoByProjectNo(@PathVariable("projectNo") Integer no) {
        return projectService.getProjectDtoByProjectNo(no);
    }
}
