package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tagRegister/{projectNo}")
    public String tagRegisterForm(@PathVariable("projectNo") Integer projectNo, Model model) {
        model.addAttribute("projectNo", projectNo);
        return "tag/tagRegisterForm";
    }

    @PostMapping("/tagRegister")
    public String tagRegister(@ModelAttribute TagRegisterRequest request) {
        tagService.registerTag(request);
        return "redirect:/project/detail/"+request.getProjectNo();
    }

    @GetMapping("/tagModify/{tagNo}")
    public String tagModifyForm(@PathVariable("tagNo") Integer tagNo, Model model) {
        model.addAttribute("tagNo", tagNo);
        return "tag/tagModifyForm";
    }

//    @PostMapping("tagModify")
//    public String tagModify(@ModelAttribute TagModifyRequest request) {
//        tagService.modifyTag(request);
//        return "redirect:/project/detail/"+request.getProjectNo();
//    }
}
