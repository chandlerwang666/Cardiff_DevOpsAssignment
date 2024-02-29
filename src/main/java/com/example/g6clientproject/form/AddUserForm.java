package com.example.g6clientproject.form;

public class AddUserForm {
    // private fields
    private String accountType;
    private String gender;
    private long contactNumber;
    private String address;
    private String email;
    private String birthday;
    //constructor

    public AddUserForm(String accountType, String gender, long contactNumber, String address, String email, String birthday) {
        this.accountType = accountType;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
    }
    // getters
    public String getAccountType() {
        return accountType;
    }

    public String getGender() {
        return gender;
    }

    public long getContactNumber() {return contactNumber;}

    public String getAddress() {return address;}

    public String getEmail() {return email;}

    public String getBirthday() {return birthday;}
}
