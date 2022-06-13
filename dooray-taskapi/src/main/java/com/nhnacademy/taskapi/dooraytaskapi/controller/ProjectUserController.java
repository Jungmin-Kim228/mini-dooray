package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserAddRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.service.ProjectUserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projectUser")
public class ProjectUserController {

    private final ProjectUserService projectUserService;

    @GetMapping("/no/{projectNo}")
    public List<ProjectUserDto> getProjectUserByProjectNo(@PathVariable("projectNo") Integer no) {
        return projectUserService.getProjectUserByProjectNo(no);
    }

    @PostMapping("/add")
    public String addProjectUser(@RequestBody ProjectUserAddRequest request) {
        projectUserService.addProjectUser(request);
        return "projectUser add success";
    }

    @PostMapping("/delete")
    public String deleteProjectUser(@RequestBody ProjectUserDeleteRequest request) {
        projectUserService.deleteProjectUser(request);
        return "projectUser delete success";
    }
}
