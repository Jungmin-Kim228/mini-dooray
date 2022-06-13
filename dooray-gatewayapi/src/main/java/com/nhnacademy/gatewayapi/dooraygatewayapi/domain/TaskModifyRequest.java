package com.nhnacademy.gatewayapi.dooraygatewayapi.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskModifyRequest {

    private String taskTitle;

    private String taskContent;

    private Integer milestoneNo;

    private List<Integer> tagNoList;

}

