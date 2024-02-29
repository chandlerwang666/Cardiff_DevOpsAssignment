package com.example.g6clientproject.repository;

import com.example.g6clientproject.DTO.UserDTO;
import com.example.g6clientproject.form.AddUserForm;
import com.example.g6clientproject.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        UserDTO UserDTO = (UserDTO) jdbcTemplate.queryForObject(
                "select userNumber,accountType,gender,contactNumber,address,email,birthday from User where email=?",
                new Object[]{email}, new UserMapper());
        return UserDTO;
    }

    @Override
    public List<UserDTO> findAllUser() {
        return jdbcTemplate.query(
                "select userNumber,accountType,gender,contactNumber,address,email,birthday from User",
                new UserMapper());
    }

    @Override
    public boolean addUser(AddUserForm addUserForm) {
        int rows = jdbcTemplate.update(
                "insert into User (accountType,gender,contactNumber,address,email,birthday) values(?,?,?,?,?,?)",
                new Object[]{addUserForm.getAccountType(), addUserForm.getGender(),
                        addUserForm.getContactNumber(), addUserForm.getAddress()},
                        addUserForm.getEmail(), addUserForm.getBirthday());
        return rows > 0;
    }

}
