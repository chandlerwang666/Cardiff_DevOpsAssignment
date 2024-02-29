package com.example.g6clientproject.DTO;

// class including all attributes we would like to know about the software
public class SoftwareDTO {
    private int id;
    private String name;
    private String software;
    private String availability;
    private String renewal;

    public SoftwareDTO(int id, String name, String software, String availability, String renewal) {
        this.id = id;
        this.name = name;
        this.software = software;
        this.availability = availability;
        this.renewal = renewal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSoftware() {
        return software;
    }

    public String getAvailability() {
        return availability;
    }

    public String getRenewal() {
        return renewal;
    }

}
