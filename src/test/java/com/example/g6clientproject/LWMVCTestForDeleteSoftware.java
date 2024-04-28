package com.example.g6clientproject;

import com.example.g6clientproject.controller.SoftwareController;
import com.example.g6clientproject.repository.SoftwareRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.ArgumentMatchers.anyInt;

@WebMvcTest(SoftwareController.class)
public class LWMVCTestForDeleteSoftware {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SoftwareRepository softwareRepo;

    @Test
    public void deleteSoftware_Success() throws Exception {
        // Setup: mock the repository to successfully delete the software
        when(softwareRepo.deleteSoftwareByid(1)).thenReturn(true);

        // Execute: Perform the POST request
        mockMvc.perform(post("/SoftwareDelete")
                        .param("id", "1")) // assume the id to delete is 1
                .andExpect(status().isOk())
                .andExpect(content().json("{'message':'Delete successfully'}"));

        // Verify: Check if the repository method was called correctly
        verify(softwareRepo).deleteSoftwareByid(1);
    }

}

//Integration test
