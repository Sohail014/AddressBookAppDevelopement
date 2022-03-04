package com.addressbookapp.AddressBookAppDevelopment.service;

import com.addressbookapp.AddressBookAppDevelopment.dto.AddressBookDTO;
import com.addressbookapp.AddressBookAppDevelopment.exception.AddressBookException;
import com.addressbookapp.AddressBookAppDevelopment.model.Address;
import com.addressbookapp.AddressBookAppDevelopment.repository.AddressRepository;
import com.addressbookapp.AddressBookAppDevelopment.util.EmailSenderService;
import com.addressbookapp.AddressBookAppDevelopment.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Slf4j generates logger instance
@Service
@Slf4j
public class AddressService implements IAddressBookService {

    //Autowired repository class to inject its dependency
    @Autowired
    AddressRepository repository;

    //Autowired Tokenutil  to inject its dependency
    @Autowired
    TokenUtil tokenutil;

    //Autowired EmailSenderService  to inject its dependency
    @Autowired
    private EmailSenderService sender;


    //Created service method which serves controller api to post data
    public String saveDataToRepo(AddressBookDTO addressBookDTO) {
        Address newAddress = new Address(addressBookDTO);
        repository.save(newAddress);
        String token = tokenutil.createToken(newAddress.getId());
        sender.sendEmail(newAddress.getEmail(), "Test Email", "Registered SuccessFully, Hi "
                + newAddress.getFirstName() + " click here -> " +
                "http://localhost:8080/addressbook/getAll/" + token);
        return token;
    }


    //Created service method which serves controller api to get record by token
    @Override
    public List<Address> getAddressBookDataToken(String token) {
        int id = tokenutil.decodeToken(token);
        Optional<Address> isContactPresent = repository.findById(id);
        if (isContactPresent.isPresent()) {
            List<Address> addressList = repository.findAll();
            return addressList;
        } else {
            System.out.println("Exception ...Token not found!");
            return null;
        }
    }

    //Created  method which serves controller api to get record by token
    @Override
    public Address getRecordOfIdFromToken(String token) {
        Integer id = tokenutil.decodeToken(token);
        Optional<Address> address = repository.findById(id);
        if (address.isPresent()) {
            repository.getById(id);
        } else {
            throw new AddressBookException("Specific id not found");
        }
        return address.get();
    }


    //Created service method which serves controller api to update record by token
    @Override
    public Address updateRecordByToken(String token, AddressBookDTO addressBookDTO) {
        Integer id = tokenutil.decodeToken(token);
        Optional<Address> addressBook = repository.findById(id);
        if (addressBook.isEmpty()) {
            throw new AddressBookException("AddressBook details for id not found");
        }
        Address newBook = new Address(id, addressBookDTO);
        repository.save(newBook);
        sender.sendEmail(newBook.getEmail(), "Test Email", "Updated SuccessFully "
                + newBook.getFirstName() + " click here -> " +
                "http://localhost:8080/addressbook/getAll/" + token);
        return newBook;
    }

    //Created service method which serves controller api to delete record by token
    @Override
    public Address deleteRecordByToken(String token) {
        Integer id = tokenutil.decodeToken(token);
        Optional<Address> newAddressBook = repository.findById(id);
        if (newAddressBook.isEmpty()) {
            throw new AddressBookException("Address Book Details not found");
        } else {
            repository.deleteById(id);
            sender.sendEmail(newAddressBook.get().getEmail(), "Test Email", "Deleted SuccessFully.. "
                    + newAddressBook.get() + " click here -> " +
                    "http://localhost:8080/addressbook/getAll/" + token);
        }
        return newAddressBook.get();
    }
}
