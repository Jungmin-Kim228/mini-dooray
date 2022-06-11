package com.nhnacademy.accountapi.doorayaccountapi.repository;

import com.nhnacademy.accountapi.doorayaccountapi.domain.UserDto;
import com.nhnacademy.accountapi.doorayaccountapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u.userId, u.userPw from User u where u.userId = ?1")
    UserDto getUserDtoByUserId(String id);
}
