package com.example.g6clientproject.repository;

import com.example.g6clientproject.form.AddHardwareForm;

public interface HardwareRepository {
    public Object findHardwareByName(String name);

    public Object findAllHardware();

    boolean addHardware(AddHardwareForm addHardwareForm);

    public boolean deleteHardwareByid(int id);

    public boolean updateHardware(int id, String name, String hardware, String availability, String checkin);

    public boolean createHardware(String name, String hardware, String availability, String checkin);
}