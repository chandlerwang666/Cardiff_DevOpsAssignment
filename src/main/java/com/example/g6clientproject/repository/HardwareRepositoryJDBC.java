
package com.example.g6clientproject.repository;

import com.example.g6clientproject.DTO.HardwareDTO;
import com.example.g6clientproject.form.AddHardwareForm;
import com.example.g6clientproject.model.HardwareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardwareRepositoryJDBC implements HardwareRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HardwareRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public HardwareDTO findHardwareByName(String name) {
        HardwareDTO hardwareDTO = (HardwareDTO) jdbcTemplate.queryForObject(
                "select ID,employee,hardware,availability,checkin from Hardware where employee=?",
                new Object[]{name}, new HardwareMapper());
        return hardwareDTO;

    }

    @Override
    public List<HardwareDTO> findAllHardware() {
        return jdbcTemplate.query(
                "select ID,employee,hardware,availability,checkin from Hardware",
                new HardwareMapper());
    }

    @Override
    public boolean addHardware(AddHardwareForm addHardwareForm) {
        int rows = jdbcTemplate.update(
                "insert into Hardware (employee, hardware, availability, checkin) values(?,?,?,?)",
                new Object[]{addHardwareForm.getName(), addHardwareForm.getHardware(),
                        addHardwareForm.getAvailability(), addHardwareForm.getCheckin()});
        return rows > 0;
    }

    @Override
    public boolean deleteHardwareByid(int id) {
        int rows = jdbcTemplate.update(
                "delete from Hardware where ID = ?",
                id);
        return rows > 0;
    }

    @Override
    public boolean updateHardware(int id, String name, String hardware, String availability, String checkin) {
        int rows = jdbcTemplate.update(
                "update Hardware set employee = ?, hardware = ?, availability = ?, checkin =? " +
                        "where ID = ?",
                name, hardware, availability, checkin, id);
        return rows > 0;
    }

    @Override
    public boolean createHardware(String name, String hardware, String availability, String checkin) {
        int rows = jdbcTemplate.update(
                "insert into Hardware (employee, hardware,availability ,checkin ) " +
                        "values (?, ?,?,? )",
                name, hardware, availability, checkin);
        return rows > 0;
    }
}