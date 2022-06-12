package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import java.util.List;

public interface TaskAdapter {

    List<TaskDto> getTaskDtoByProjectNo(Integer projectNo);
}
