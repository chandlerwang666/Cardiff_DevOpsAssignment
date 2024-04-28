package com.example.g6clientproject;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class HardwareMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHome() throws Exception {
        this.mockMvc.perform(get("/Home")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Admin")));
    }

    @Test
    @WithMockUser(username = "admin", password = "adminlogin", roles = "ADMIN")
    public void getSoftwareTest() throws Exception {
        this.mockMvc.perform(get("/HardwareView")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Tom Hardy")));
    }
}

//Integration test