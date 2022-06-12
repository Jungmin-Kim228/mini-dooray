package com.nhnacademy.taskapi.dooraytaskapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

    private Integer taskNo;

    private String taskTitle;

    private String taskRegistrant;
}
