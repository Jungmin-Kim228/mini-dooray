package com.nhnacademy.taskapi.dooraytaskapi.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskModifyRequest {

    private Integer taskNo;

    private String taskTitle;

    private String taskContent;

    private Integer milestoneNo;

    private List<Integer> tagNoList;

}

