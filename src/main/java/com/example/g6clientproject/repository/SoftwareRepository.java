package com.example.g6clientproject.repository;

import com.example.g6clientproject.form.AddSoftwareForm;

// methods we would like to carry out on out database
public interface SoftwareRepository {
    public Object findSoftwareByName(String name);

    public Object findAllSoftware();

    boolean addSoftware(AddSoftwareForm addSoftwareForm);


    public boolean deleteSoftwareByid(int id);

   public boolean updateSoftware(int id, String name, String software, String availability,
                                 String renewal);

    public boolean createSoftware(String name, String software, String availability,
                                  String renewal );
}
