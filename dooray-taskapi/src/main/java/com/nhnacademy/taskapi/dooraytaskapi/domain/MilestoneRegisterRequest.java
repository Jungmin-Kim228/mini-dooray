package com.nhnacademy.taskapi.dooraytaskapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilestoneRegisterRequest {

    private String milestoneName;

    private Integer projectNo;
}
