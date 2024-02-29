package com.example.g6clientproject.form;

public class AddHardwareForm {
    // private fields
    private String name;
    private String hardware;
    private String availability;
    private String checkin;
    //constructor

    public AddHardwareForm(String name, String hardware, String availability, String checkin) {
        this.name = name;
        this.hardware = hardware;
        this.availability = availability;
        this.checkin = checkin;
    }
    // getters
    public String getName() {
        return name;
    }

    public String getHardware() {
        return hardware;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCheckin() {
        return checkin;
    }
}
