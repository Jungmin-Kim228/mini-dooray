package com.nhnacademy.taskapi.dooraytaskapi.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRegisterRequest {

    private String taskTitle;

    private String taskContent;

    private Integer milestoneNo;

    private List<Integer> tagNoList;

    private Integer projectNo;

    private String taskRegistrant;
}
