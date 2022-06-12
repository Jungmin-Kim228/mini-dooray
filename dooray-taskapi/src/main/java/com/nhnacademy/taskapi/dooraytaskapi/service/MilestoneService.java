package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneRegisterRequest;
import java.util.List;

public interface MilestoneService {

    List<MilestoneDto> getMilestoneByProjectNo(Integer no);

    void registerMilestone(MilestoneRegisterRequest request);
}
