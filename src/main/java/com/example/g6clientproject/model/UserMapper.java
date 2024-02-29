package com.example.g6clientproject.model;

import com.example.g6clientproject.DTO.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    // these are items we are retrieving from the User database
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(rs.getInt("userNumber"),
                rs.getString("accountType"),
                rs.getString("gender"),
                rs.getInt("contactNumber"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("birthday"));
    }
}