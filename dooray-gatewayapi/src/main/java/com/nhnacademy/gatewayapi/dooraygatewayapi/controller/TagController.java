package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagModifyRequest;
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

    @GetMapping("/tag/register/{projectNo}")
    public String tagRegisterForm(@PathVariable("projectNo") Integer projectNo, Model model) {
        model.addAttribute("projectNo", projectNo);
        return "tag/tagRegisterForm";
    }

    @PostMapping("/tag/register")
    public String tagRegister(@ModelAttribute TagRegisterRequest request) {
        tagService.registerTag(request);
        return "redirect:/project/detail/"+request.getProjectNo();
    }

    @GetMapping("/tag/modify/{tagNo}")
    public String tagModifyForm(@PathVariable("tagNo") Integer tagNo, Model model) {
        model.addAttribute("tagNo", tagNo);
        return "tag/tagModifyForm";
    }

    @PostMapping("/tag/modify")
    public String tagModify(@ModelAttribute TagModifyRequest request) {
        Integer projectNo = tagService.modifyTag(request);
        return "redirect:/project/detail/"+projectNo;
    }

    @GetMapping("/tag/delete/{tagNo}")
    public String tagDelete(@PathVariable("tagNo") Integer tagNo) {
        Integer projectNo = tagService.deleteTag(tagNo);
        return "redirect:/project/detail/"+projectNo;
    }
}
