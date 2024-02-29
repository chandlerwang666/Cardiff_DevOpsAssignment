package com.example.g6clientproject.model;

import com.example.g6clientproject.DTO.SoftwareDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

// result-set linked to the MariaDB database of Software Assets
public class SoftwareMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SoftwareDTO(rs.getInt("ID"),
                rs.getString("employee"),
                rs.getString("software"),
                rs.getString("availability"),
                rs.getString("renewal"));
    }
}
