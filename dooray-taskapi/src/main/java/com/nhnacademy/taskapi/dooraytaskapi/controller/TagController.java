package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.DeleteRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TagRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @GetMapping("/projectNo/{projectNo}")
    public List<TagDto> getTagByProjectNo(@PathVariable("projectNo") Integer no) {
        return tagService.getTagByProjectNo(no);
    }

    @PostMapping("/register")
    public String registerTag(@RequestBody TagRegisterRequest request) {
        tagService.registerTag(request);
        return "tag register success";
    }

    @PostMapping("/modify")
    public Integer modifyTag(@RequestBody TagModifyRequest request) {
        return tagService.modifyTag(request);
    }

    @PostMapping("/delete")
    public Integer deleteTag(@RequestBody DeleteRequest request) {
        return tagService.deleteTag(request.getNo());
    }

    @GetMapping("/taskNo/{taskNo}")
    public List<TagDto> getTagDtosByTaskNo(@PathVariable("taskNo") Integer taskNo) {
        return tagService.getTagDtosByTaskNo(taskNo);
    }
}
