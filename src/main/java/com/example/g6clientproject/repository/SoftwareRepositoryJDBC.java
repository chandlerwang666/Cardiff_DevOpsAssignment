package com.example.g6clientproject.repository;

import com.example.g6clientproject.DTO.SoftwareDTO;
import com.example.g6clientproject.form.AddSoftwareForm;
import com.example.g6clientproject.model.SoftwareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SoftwareRepositoryJDBC implements SoftwareRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SoftwareRepositoryJDBC(JdbcTemplate sTemplate) {
        jdbcTemplate = sTemplate;
    }

    @Override
    public SoftwareDTO findSoftwareByName(String name) {
        SoftwareDTO softwareDTO = (SoftwareDTO) jdbcTemplate.queryForObject(
                "select ID,employee,software,availability,renewal from Software where employee=?",
                new Object[]{name}, new SoftwareMapper());
        return softwareDTO;

    }

    @Override
    public List<SoftwareDTO> findAllSoftware() {
        return jdbcTemplate.query(
                "select ID,employee,software,availability,renewal from Software",
                new SoftwareMapper());
    }

    @Override
    public boolean addSoftware(AddSoftwareForm addSoftwareForm) {
        int rows = jdbcTemplate.update(
                "insert into Software (employee, software, availability, renewal) values(?,?,?,?)",
                new Object[]{addSoftwareForm.getName(), addSoftwareForm.getSoftware(),
                        addSoftwareForm.getAvailability(), addSoftwareForm.getRenewal()});
        return rows > 0;
    }

    @Override
    public boolean deleteSoftwareByid(int id) {
        int rows = jdbcTemplate.update(
                "delete from Software where ID = ?",
                id);
        return rows > 0;
    }

    @Override
    public boolean updateSoftware(int id, String employee, String software, String availability, String renewal) {
        int rows = jdbcTemplate.update(
                "update Software set employee = ?, software = ?, availability = ? , renewal =? " +
                        "where ID = ?",
                employee, software, availability,renewal,id);
        return rows > 0;
    }

   @Override
    public boolean createSoftware(String name, String software, String availability, String renewal) {
        int rows = jdbcTemplate.update(
                "insert into Software (employee, software,availability, renewal) " +
                        "values (?, ?,?,? )",
                name, software, availability, renewal);
        return rows > 0;
    }
}



