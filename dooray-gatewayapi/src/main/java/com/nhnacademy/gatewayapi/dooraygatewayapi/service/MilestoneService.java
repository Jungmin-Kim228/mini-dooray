package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import java.util.List;

public interface MilestoneService {

    List<MilestoneDto> getMilestoneDtoByProjectNo(Integer projectNo);
}
