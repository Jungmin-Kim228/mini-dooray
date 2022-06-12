package com.nhnacademy.taskapi.dooraytaskapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {

    private Integer projectNo;

    private String projectName;

    private String adminId;

    private String projectStatus;
}
