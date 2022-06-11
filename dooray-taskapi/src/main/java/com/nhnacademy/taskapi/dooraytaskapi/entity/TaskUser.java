package com.nhnacademy.taskapi.dooraytaskapi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
@Table(name = "task_user")
public class TaskUser {

    @EmbeddedId
    private Pk pk;

    @MapsId("taskNo")
    @ManyToOne
    @JoinColumn(name = "task_no")
    private Task task;

    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "user_id")
        private String userId;

        @Column(name = "task_no")
        private Integer taskNo;
    }
}
