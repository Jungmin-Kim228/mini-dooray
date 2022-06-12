package com.nhnacademy.gatewayapi.dooraygatewayapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilestoneRegisterRequest {

    private String milestoneName;

    private Integer projectNo;
}
