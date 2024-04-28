package com.example.g6clientproject;

import com.example.g6clientproject.DTO.*;
import com.example.g6clientproject.controller.*;
import com.example.g6clientproject.configure.SecFig;

import com.example.g6clientproject.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HardwareController.class)
@Import(SecFig.class)

public class LightweightMockMVCTestforHardwareController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HardwareRepository HardwareRepo;

//    @Test
//    public void testHome() throws Exception {
//        this.mockMvc.perform(get("/Home")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Admin")));
//    }

    @Test
    @WithMockUser(username = "admin", password = "adminlogin", roles = "ADMIN")
    public void getHardwareTest() throws Exception {

        HardwareDTO hardware = new HardwareDTO(4, "Qiming", "Laptop", "no", "2022-06-12");

        given(this.HardwareRepo.findAllHardware()).willReturn(Arrays.asList(hardware));

        this.mockMvc.perform(get("/HardwareView")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Qiming")));
    }

}

//Integration test
