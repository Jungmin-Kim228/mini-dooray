package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Tag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.TaskTag;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.TagNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TagRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TaskTagRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;
    private final TaskTagRepository taskTagRepository;

    @Override
    public List<TagDto> getTagByProjectNo(Integer no) {
        return tagRepository.getTagsByProjectNo(no);
    }

    @Override
    @Transactional
    public void registerTag(TagRegisterRequest request) {
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(
            ProjectNotFoundException::new);
        Tag tag = Tag.addTag()
            .name(request.getTagName())
            .project(project)
            .build();
        tagRepository.save(tag);
    }

    @Override
    @Transactional
    public Integer modifyTag(TagModifyRequest request) {
        Tag tag = tagRepository.findById(request.getTagNo()).orElseThrow(TagNotFoundException::new);
        tag.setTagName(request.getTagName());
        tagRepository.save(tag);
        return tag.getProject().getProjectNo();
    }

    @Override
    @Transactional
    public Integer deleteTag(Integer tagNo) {
        Tag tag = tagRepository.findById(tagNo).orElseThrow(TagNotFoundException::new);
        Integer projectNo = tag.getProject().getProjectNo();

        List<TaskTag> taskTags = taskTagRepository.findTaskTagsByPk_TagNo(tag.getTagNo());
        taskTagRepository.deleteAll(taskTags);

        tagRepository.delete(tag);
        return projectNo;
    }

    @Override
    public List<TagDto> getTagDtosByTaskNo(Integer taskNo) {
        return tagRepository.getTagDtosByTaskNo(taskNo);
    }
}
