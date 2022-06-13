package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserAddRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectUserService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProjectUserController {

    private final ProjectUserService projectUserService;
    private final UserService userService;

    @GetMapping("/projectUser/add/{projectNo}/{adminId}")
    public String projectUserAddForm(Authentication authentication,
                                     @PathVariable("projectNo") Integer projectNo,
                                     @PathVariable("adminId") String adminId, Model model) {
        String userName = ((User) authentication.getPrincipal()).getUsername();
        if (!userName.equals(adminId)) {
            return "redirect:/project/detail/"+projectNo;
        }

        List<ProjectUserDto> allUserIds = userService.getAllUserId();
        List<ProjectUserDto> userIds = projectUserService.excludeMember(allUserIds, projectNo);
        model.addAttribute("projectNo", projectNo);
        model.addAttribute("userIds", userIds);
        return "projectUser/projectUserAddForm";
    }

    @PostMapping("/projectUser/add")
    public String projectUserAdd(@ModelAttribute ProjectUserAddRequest request) {
        projectUserService.addProjectUser(request);
        return "redirect:/project/detail/"+request.getProjectNo();
    }

    @GetMapping("/projectUser/delete/{userId}/{projectNo}")
    public String projectUserDelete(@PathVariable("userId") String userId,
                                    @PathVariable("projectNo") Integer projectNo) {
        ProjectUserDeleteRequest request = new ProjectUserDeleteRequest(userId, projectNo);
        projectUserService.deleteProjectUser(request);
        return "redirect:/project/detail/"+projectNo;
    }
}
