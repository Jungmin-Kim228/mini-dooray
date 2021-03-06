package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskRegisterRequest;
import java.util.List;

public interface TaskAdapter {

    List<TaskDto> getTaskDtosByProjectNo(Integer projectNo);

    void registerTask(TaskRegisterRequest request);

    TaskDto getTaskDtoByTaskNo(Integer taskNo);

    Integer modifyTask(TaskModifyRequest request);

    Integer deleteTask(Integer taskNo);
}
