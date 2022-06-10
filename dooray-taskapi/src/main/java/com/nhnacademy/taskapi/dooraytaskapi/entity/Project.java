package com.nhnacademy.taskapi.dooraytaskapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Integer projectNo;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "project_status")
    private String projectStatus;
}
