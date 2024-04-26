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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.BDDMockito.*;

import com.example.g6clientproject.controller.HardwareController;
import com.example.g6clientproject.repository.HardwareRepository;
import com.example.g6clientproject.form.AddHardwareForm;

@RunWith(SpringRunner.class)
@WebMvcTest(HardwareController.class)
@Import(SecFig.class)
public class LWMVCTestForAddHardware {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HardwareRepository hardwareRepo;

    @Test
    @WithMockUser(username = "admin", password = "adminlogin", roles = "ADMIN")
    public void testAddHardwareSuccess() throws Exception {
        // Setup the mock behavior
        when(hardwareRepo.addHardware(any(AddHardwareForm.class))).thenReturn(true);

        // Perform the request
        mockMvc.perform(post("/Hardware")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "New Hardware")
                        .param("hardware", "Laptop")
                        .param("availability", "yes")
                        .param("checkin", "2023-10-01"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("AllHardwareDetails"));  // Assuming "AllHardwareDetails" is the view name on successful addition
    }
}
