package com.example.g6clientproject;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityFullContainerMockMVtests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNotAddSoftware() throws Exception {
        this.mockMvc.perform(get("/Welcome")).andDo(print()).andExpect(status().isFound())
                .andExpect(header().string("Location", "http://localhost/Home"));
    }

    @Test
    public void testNotAddHardware() throws Exception {
        this.mockMvc.perform(get("/HardwareView")).andDo(print()).andExpect(status().isFound())
                .andExpect(header().string("Location", "http://localhost/Home"));
    }

    @Test
    public void testNotAddUser() throws Exception {
        this.mockMvc.perform(get("/UserInfo")).andDo(print()).andExpect(status().isFound())
                .andExpect(header().string("Location", "http://localhost/Home"));
    }
}

//Integration test
