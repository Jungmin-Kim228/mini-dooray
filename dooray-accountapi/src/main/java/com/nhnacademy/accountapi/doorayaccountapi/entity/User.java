package com.nhnacademy.accountapi.doorayaccountapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_status")
    private String userStatus;

    @Builder(builderMethodName = "addUser")
    public static User registerUser(String email, String id, String pw) {
        User user = new User();
        user.setUserEmail(email);
        user.setUserId(id);
        user.setUserPw(pw);
        user.setUserStatus("가입");
        return user;
    }
}
