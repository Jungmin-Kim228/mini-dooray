package com.nhnacademy.taskapi.dooraytaskapi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project_user")
public class ProjectUser {
    @EmbeddedId
    private Pk pk;
    // here 연관관계 매핑해야함

    @Column(name = "user_id")
    private String userId;

    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "project_no")
        private Integer projectNo;

        @Column(name = "user_no")
        private Integer userNo;
    }
}
