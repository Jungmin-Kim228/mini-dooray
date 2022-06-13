package com.nhnacademy.gatewayapi.dooraygatewayapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectUserDeleteRequest {

    private String userId;

    private Integer projectNo;
}
