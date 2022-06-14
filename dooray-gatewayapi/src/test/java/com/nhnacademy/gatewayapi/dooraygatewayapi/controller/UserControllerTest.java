package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class UserControllerTest {

    private UserService userService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    void userRegisterForm() throws Exception {
        mockMvc.perform(get("/userRegister"))
            .andExpect(view().name("user/userRegisterForm"));
    }

    @Test
    void userRegister() throws Exception{
        when(userService.registerUser(any())).thenReturn("userId1");

        MvcResult mvcResult = mockMvc.perform(post("/user/register"))
                                     .andExpect(view().name("user/userRegisterSuccess"))
                                     .andReturn();

        assertThat(mvcResult.getModelAndView().getModel().get("userId")).isEqualTo("userId1");
    }
}
