package com.example.g6clientproject;

import  com.example.g6clientproject.DTO.SoftwareDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JUnitTestDTO {
    @Test
    public void SoftwareDTOTest() {
        SoftwareDTO Software = new SoftwareDTO(1,"Qiming","MS Office","Yes", "01-01-2024");
        assertEquals(1, Software.getId());
        assertEquals("Qiming", Software.getName());
        assertEquals("MS Office", Software.getSoftware());
        assertEquals("Yes", Software.getAvailability());
        assertEquals("01-01-2024", Software.getRenewal());
    }
}
