package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneRegisterRequest;
import java.util.List;

public interface MilestoneService {

    List<MilestoneDto> getMilestoneDtosByProjectNo(Integer projectNo);

    void registerMilestone(MilestoneRegisterRequest request);

    Integer modifyMilestone(MilestoneModifyRequest request);

    Integer deleteMilestone(Integer milestoneNo);

    MilestoneDto getMilestoneDtoByTaskNo(Integer taskNo);
}
