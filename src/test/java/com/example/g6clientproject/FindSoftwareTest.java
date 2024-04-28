package com.example.g6clientproject;

import com.example.g6clientproject.repository.SoftwareRepositoryJDBC;
import com.example.g6clientproject.repository.SoftwareRepository;
import com.example.g6clientproject.DTO.*;

import org.junit.jupiter.api.BeforeEach;
import com.example.g6clientproject.model.SoftwareMapper;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.test.context.support.WithMockUser;


@ExtendWith(MockitoExtension.class)
public class FindSoftwareTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private SoftwareRepositoryJDBC softwareRepositoryJDBC;

    @BeforeEach
    void setUp() {
        softwareRepositoryJDBC = new SoftwareRepositoryJDBC(jdbcTemplate);
    }

    @Test
    @WithMockUser(username = "admin", password = "adminlogin", roles = "ADMIN")
    public void findSoftwareByName_returnsSoftwareDTO() {
        // Arrange
        SoftwareDTO expectedDTO = new SoftwareDTO(1, "Alice", "MS Office", "Available", "2023-10-01");
        when(jdbcTemplate.queryForObject(
                any(String.class),
                any(Object[].class),
                any(SoftwareMapper.class))
        ).thenReturn(expectedDTO);

        // Act
        SoftwareDTO actualDTO = softwareRepositoryJDBC.findSoftwareByName("Alice");

        // Assert
        assertEquals(expectedDTO.getName(), actualDTO.getName());
    }

}
