package com.nhnacademy.accountapi.doorayaccountapi.repository;

import com.nhnacademy.accountapi.doorayaccountapi.domain.UserDto;
import com.nhnacademy.accountapi.doorayaccountapi.domain.UserIdOnlyDto;
import com.nhnacademy.accountapi.doorayaccountapi.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    UserDto findByUserId(String id);

    List<UserIdOnlyDto> getAllBy();

}
