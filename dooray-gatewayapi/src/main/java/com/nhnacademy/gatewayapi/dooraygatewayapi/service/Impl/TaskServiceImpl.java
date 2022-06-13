package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.TaskAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TaskService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskAdapter taskAdapter;

    @Override
    public List<TaskDto> getTaskDtosByProjectNo(Integer projectNo) {
        return taskAdapter.getTaskDtosByProjectNo(projectNo);
    }

    @Override
    public void registerTask(TaskRegisterRequest request) {
        taskAdapter.registerTask(request);
    }

    @Override
    public TaskDto getTaskDtoByTaskNo(Integer taskNo) {
        return taskAdapter.getTaskDtoByTaskNo(taskNo);
    }

    @Override
    public Integer modifyTask(TaskModifyRequest request) {
        return taskAdapter.modifyTask(request);
    }

    @Override
    public Integer deleteTask(Integer taskNo) {
        return taskAdapter.deleteTask(taskNo);
    }
}
