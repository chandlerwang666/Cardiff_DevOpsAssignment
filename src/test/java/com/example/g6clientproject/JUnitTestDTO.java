package com.example.g6clientproject;

import  com.example.g6clientproject.DTO.SoftwareDTO;
import  com.example.g6clientproject.DTO.UserDTO;
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

    @Test
    public void UserDTOTest() {
        UserDTO user = new UserDTO(1, "admin", "male", 898, "3 sharrold road, CF23 4FD", "dave@bipSync.com", "1990-12-01");
        assertEquals(1, user.getUserNumber());
        assertEquals("admin", user.getAccountType());
        assertEquals("male", user.getGender());
        assertEquals(898, user.getContactNumber());
        assertEquals("3 sharrold road, CF23 4FD", user.getAddress());
        assertEquals("dave@bipSync.com", user.getEmail());
        assertEquals("1990-12-01", user.getBirthday());
    }
}

