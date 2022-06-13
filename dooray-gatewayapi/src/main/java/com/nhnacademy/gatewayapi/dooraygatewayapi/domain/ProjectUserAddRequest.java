package com.nhnacademy.gatewayapi.dooraygatewayapi.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectUserAddRequest {

    private List<String> userIdList;

    private Integer projectNo;
}
