package com.addressbookapp.AddressBookAppDevelopment.controller;


import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookapplication.model.Address;
import com.bridgelabz.addressbookapplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")

public class AddressBookController {
    @Autowired
    AddressService service;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name) {
        String message = service.getMessage(name);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PostMapping("/postMessage")
    public ResponseEntity<String> postMessage(@RequestBody Address address) {
        String message = service.postMessage(address);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @GetMapping("/putMessage/{name}")
    public ResponseEntity<String> putMessage(@PathVariable String name) {
        String message = service.putMessage(name);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    //Ability to get welcome message
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        String message = service.getWelcome();
        return new ResponseEntity(message, HttpStatus.OK);
    }

    //Ability to store a address book record to repo
    @PostMapping("/create")
    public ResponseEntity<String> saveDataToRepo(@RequestBody AddressBookDTO addressBookDTO) {
        Address newAddress = service.saveDataToRepo(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record created successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getDataFromRepo() {
        List<Address> newAddress = service.getRecord();
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getRecordFromRepoByID(@PathVariable Integer id) {
        Address newAddress = service.getRecordById(id);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{firstName}")
    public ResponseEntity<String> getRecordFromRepoByFirstName(@PathVariable String firstName) {
        List<Address> newAddress = service.getRecordByFirstName(firstName);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular firstName retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getRecordFromRepoByName() {
        List<Address> newAddress = service.getRecordByName();
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular name retrieved successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRecordById(@PathVariable Integer id, @RequestBody AddressBookDTO addressBookDTO) {
        Address newAddress = service.updateRecordById(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record updated successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecordById(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully", service.deleteRecordById(id));
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}