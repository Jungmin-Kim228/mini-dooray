package com.nhnacademy.taskapi.dooraytaskapi.repository;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Integer>{

    List<MilestoneDto> getMilestonesByProject_ProjectNo(Integer no);

    @Query("select m from Milestone m inner join Task t on t.milestone.milestoneNo = m.milestoneNo where t.taskNo = ?1")
    MilestoneDto getMilestoneDtoByTaskNo(Integer taskNo);
}
