package com.example.g6clientproject.form;

// class including all attributes we would like to know when adding software
public class AddSoftwareForm {
    private String name;
    private String software;
    private String availability;
    private String renewal;

    public AddSoftwareForm(String name, String software, String availability, String renewal) {
        this.name = name;
        this.software = software;
        this.availability = availability;
        this.renewal = renewal;
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
