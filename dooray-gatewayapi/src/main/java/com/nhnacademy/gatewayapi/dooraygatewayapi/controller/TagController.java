package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tagRegister/{projectNo}")
    public String tagRegisterForm(@PathVariable("projectNo") Integer projectNo, Model model) {
        model.addAttribute("projectNo", projectNo);
        return "tag/tagRegisterForm";
    }

    // here 태그 추가 폼에서 받은 postMapping
}
