package com.nhnacademy.taskapi.dooraytaskapi.repository;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Tag;
import com.nhnacademy.taskapi.dooraytaskapi.repository.custom.TagRepositoryCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>, TagRepositoryCustom {

}
