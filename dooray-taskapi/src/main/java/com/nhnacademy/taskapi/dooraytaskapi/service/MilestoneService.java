package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import java.util.List;

public interface MilestoneService {

    List<MilestoneDto> getMilestoneByProjectNo(Integer no);
}
