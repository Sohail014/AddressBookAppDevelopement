package com.addressbookapp.AddressBookAppDevelopment.service;


import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.Address;

public interface IAddressBookService {
    public String getMessage(String name);

    public String postMessage(Address address);

    public String putMessage(String name);

    public String getWelcome();

    public Address saveDataToRepo(AddressBookDTO addressBookDTO);

    public String deleteDataById(Integer id);

}