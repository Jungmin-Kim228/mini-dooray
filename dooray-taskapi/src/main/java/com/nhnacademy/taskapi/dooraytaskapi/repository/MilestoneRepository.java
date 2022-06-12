package com.nhnacademy.taskapi.dooraytaskapi.repository;

import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.repository.custom.MilestoneRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Integer>,
    MilestoneRepositoryCustom {

}
