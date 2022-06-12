package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
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

    private final TagService tagServcie;

    @GetMapping("/no/{projectNo}")
    public List<TagDto> getTagByProjectNo(@PathVariable("projectNo") Integer no) {
        return tagServcie.getTagByProjectNo(no);
    }

    @PostMapping("/register")
    public void registerTag(@RequestBody TagRegisterRequest request) {
        tagServcie.registerTag(request);
    }
}
