package com.nhnacademy.accountapi.doorayaccountapi.repository;

import com.nhnacademy.accountapi.doorayaccountapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
