package com.nhnacademy.taskapi.dooraytaskapi.controller;

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

    @GetMapping("/no/{projectNo}")
    public List<TagDto> getTagByProjectNo(@PathVariable("projectNo") Integer no) {
        return tagService.getTagByProjectNo(no);
    }

    @PostMapping("/register")
    public void registerTag(@RequestBody TagRegisterRequest request) {
        tagService.registerTag(request);
    }

    @PostMapping("/modify")
    public Integer modifyTag(@RequestBody TagModifyRequest request) {
        return tagService.modifyTag(request);
    }
}
