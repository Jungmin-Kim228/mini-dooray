package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import java.util.List;

public interface MilestoneAdapter {

    List<MilestoneDto> getMilestoneDtosByProjectNo(Integer projectNo);
}
