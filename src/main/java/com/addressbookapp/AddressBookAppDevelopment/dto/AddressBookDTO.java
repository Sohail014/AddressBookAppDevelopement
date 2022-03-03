package com.addressbookapp.AddressBookAppDevelopment.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {
    @NotEmpty(message = "First name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee firstName is Invalid")
    private String firstName;

    @NotEmpty(message = "Last name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee firstName is Invalid")
    private String lastName;

    @Email
    private String email;

    @NotEmpty(message = "Phone number cant be empty")
    private long phoneNumber;

    @NotEmpty(message = "city cant be empty")
    private String city;

    @NotEmpty(message = "State cant be empty")
    private String state;
    @NotEmpty(message = "zip cant be empty")
    private Integer zip;


    public AddressBookDTO(String firstName, String lastName, String email, long phoneNumber, String city, String state,
                          Integer zip) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}