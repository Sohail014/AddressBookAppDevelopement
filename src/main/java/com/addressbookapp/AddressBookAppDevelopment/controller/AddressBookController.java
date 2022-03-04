package com.addressbookapp.AddressBookAppDevelopment.controller;


import com.addressbookapp.AddressBookAppDevelopment.dto.AddressBookDTO;
import com.addressbookapp.AddressBookAppDevelopment.dto.ResponseDTO;
import com.addressbookapp.AddressBookAppDevelopment.exception.AddressBookException;
import com.addressbookapp.AddressBookAppDevelopment.model.Address;
import com.addressbookapp.AddressBookAppDevelopment.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Created controller so that we can perform rest api calls
@RestController
//Maps http request to method of mvc and rest controller
@RequestMapping("/addressbook")

public class AddressBookController {
    //Autowired IAddressBookService interface so we can inject its dependency here
    @Autowired
    IAddressBookService service;



    //Ability to store  address  record to repository
    @PostMapping("/create")
    public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        String newAddress = service.saveDataToRepo(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record created successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    //Ability to get all record from repository
    @GetMapping(value = "/getAll/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookDataToken(@PathVariable String token) {
        List<Address> entity = service.getAddressBookDataToken(token);
        ResponseDTO responseDTO = new ResponseDTO("Data retrived successfully :", entity);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }


    //Ability to get address  record by token
    @GetMapping("/get/{token}")
    public ResponseEntity<String> getRecordFromRepoByID(@PathVariable String token) throws AddressBookException {
        Address entity = service.getRecordOfIdFromToken(token);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", entity);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }


    //Ability to update addressbook record to repository
    @PutMapping("/update/{token}")
    public ResponseEntity<String> updateRecordById(@PathVariable String token, @Valid @RequestBody AddressBookDTO addressBookDTO)
            throws AddressBookException {
        Address entity = service.updateRecordByToken(token, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record updated successfully", entity);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    //Ability to delete address book record to repository
    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordById(@PathVariable String token) throws AddressBookException {
        ResponseDTO dto = new ResponseDTO("Address Book Record deleted successfully", service.deleteRecordByToken(token));
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}