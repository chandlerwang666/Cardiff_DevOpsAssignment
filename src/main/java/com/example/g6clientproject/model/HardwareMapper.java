package com.example.g6clientproject.model;

import com.example.g6clientproject.DTO.HardwareDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HardwareMapper implements RowMapper {
    // these are items we are retrieving from the hardware database
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new HardwareDTO(rs.getInt("ID"),
                rs.getString("employee"),
                rs.getString("hardware"),
                rs.getString("availability"),
                rs.getString("checkin"));
    }
}
