package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.service.ProjectUserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
