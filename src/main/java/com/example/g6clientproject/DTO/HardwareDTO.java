package com.example.g6clientproject.DTO;

public class HardwareDTO {
    // private fields
    private int id;
    private String name;
    private String hardware;
    private String availability;
    private String checkin;

    //constructor

    public HardwareDTO(int id, String name, String hardware, String availability, String checkin) {
        this.id = id;
        this.name = name;
        this.hardware = hardware;
        this.availability = availability;
        this.checkin = checkin;
    }

    //getters
    public int getId() {
        return id;
    }

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
