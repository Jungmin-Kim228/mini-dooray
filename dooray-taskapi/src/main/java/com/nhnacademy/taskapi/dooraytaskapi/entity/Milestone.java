package com.nhnacademy.taskapi.dooraytaskapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "milestone")
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_no")
    private Integer milestoneNo;

    @Column(name = "milestone_name")
    private String milestoneName;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;

    @Builder(builderMethodName = "addMilestone")
    public static Milestone registerMilestone(String name, Project project) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneName(name);
        milestone.setProject(project);
        return milestone;
    }
}
