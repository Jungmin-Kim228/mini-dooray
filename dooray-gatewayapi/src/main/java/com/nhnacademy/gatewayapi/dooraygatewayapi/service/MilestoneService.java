package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import java.util.List;

public interface MilestoneService {

    List<MilestoneDto> getMilestoneDtosByProjectNo(Integer projectNo);
}
