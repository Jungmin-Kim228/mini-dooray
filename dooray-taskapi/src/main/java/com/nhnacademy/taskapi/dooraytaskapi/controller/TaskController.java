package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.service.TaskService;
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
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/no/{projectNo}")
    public List<TaskDto> getTaskByProjectNo(@PathVariable("projectNo") Integer no) {
        return taskService.getTaskByProjectNo(no);
    }

    @PostMapping("/register")
    public void registerTask(@RequestBody TaskRegisterRequest request) {
        taskService.registerTask(request);
    }
}
