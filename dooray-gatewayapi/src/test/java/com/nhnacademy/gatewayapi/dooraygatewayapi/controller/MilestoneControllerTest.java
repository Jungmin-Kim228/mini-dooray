package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import static org.mockito.Mockito.mock;

import com.nhnacademy.gatewayapi.dooraygatewayapi.service.MilestoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class MilestoneControllerTest {

    private MilestoneService milestoneService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        milestoneService = mock(MilestoneService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new MilestoneController(milestoneService)).build();
    }

    @Test
    void milestoneRegisterForm() {
        
    }
}
