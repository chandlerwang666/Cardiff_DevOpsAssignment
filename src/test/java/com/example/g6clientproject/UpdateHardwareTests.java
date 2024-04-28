package com.example.g6clientproject;
import com.example.g6clientproject.controller.HardwareController;
import com.example.g6clientproject.repository.HardwareRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = HardwareController.class)
public class UpdateHardwareTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HardwareRepository hardwareRepo;

    @Test
    public void updateHardware_Success() throws Exception {
        // Arrange - mock the hardwareRepo behavior for a successful update
        when(hardwareRepo.updateHardware(anyInt(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        // Act & Assert - perform the request and expect a 200 OK with the success message
        mockMvc.perform(post("/HardwareUpdate")
                        .param("id", "1")
                        .param("name", "New Name")
                        .param("hardware", "New Hardware")
                        .param("availability", "yes")
                        .param("checkin", "2024-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Update is success\"}"));

        // Verify - ensure the method was called with the expected arguments
        verify(hardwareRepo).updateHardware(1, "New Name", "New Hardware", "yes", "2024-01-01");
    }

    @Test
    public void updateHardware_Failure() throws Exception {
        // Arrange - mock the hardwareRepo behavior for a failed update
        doThrow(new RuntimeException("Update fails!")).when(hardwareRepo).updateHardware(anyInt(), anyString(), anyString(), anyString(), anyString());

        // Act & Assert - perform the request and expect a 417 EXPECTATION_FAILED with the failure message
        mockMvc.perform(post("/HardwareUpdate")
                        .param("id", "1")
                        .param("name", "New Name")
                        .param("hardware", "New Hardware")
                        .param("availability", "yes")
                        .param("checkin", "2024-01-01"))
                .andExpect(status().isExpectationFailed())
                .andExpect(content().json("{\"message\":\"Update fails!\"}"));

        // Verify - ensure the method was called with the expected arguments
        verify(hardwareRepo).updateHardware(1, "New Name", "New Hardware", "yes", "2024-01-01");
    }
}
