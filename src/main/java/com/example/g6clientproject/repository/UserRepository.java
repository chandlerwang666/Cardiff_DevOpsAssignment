package com.example.g6clientproject.repository;

import com.example.g6clientproject.form.AddUserForm;

public interface UserRepository {
    public Object findUserByEmail(String email);

    public Object findAllUser();

    boolean addUser(AddUserForm addUserForm);
}