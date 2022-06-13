package com.nhnacademy.taskapi.dooraytaskapi.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectUserAddRequest {

    private List<String> userIdList;

    private Integer projectNo;
}
