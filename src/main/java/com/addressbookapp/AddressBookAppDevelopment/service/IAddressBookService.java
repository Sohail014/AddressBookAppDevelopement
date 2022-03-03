package com.addressbookapp.AddressBookAppDevelopment.service;

import com.addressbookapp.AddressBookAppDevelopment.dto.AddressBookDTO;
import com.addressbookapp.AddressBookAppDevelopment.model.Address;


import java.util.List;

//Created interface for all service methods to achieve abstraction
public interface IAddressBookService {

    public String getWelcome();

    public Address saveDataToRepo(AddressBookDTO addressBookDTO);

    public Address getRecordById(Integer id);

    public List<Address> getRecord();

    public Address updateRecordById(Integer id, AddressBookDTO addressBookDTO);

    public String deleteRecordById(Integer id);
}