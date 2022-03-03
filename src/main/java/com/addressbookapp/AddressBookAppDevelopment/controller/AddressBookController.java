package com.addressbookapp.AddressBookAppDevelopment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")

public class AddressBookController {
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name) {
        String message = "Welcome " + "  " + name;
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PostMapping("/postMessage/{firstName}")
    public ResponseEntity<String> postMessage(@PathVariable String firstName, @RequestParam String lastName) {
        String message = "Helloo " + " " + firstName + " " + lastName;
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PutMapping("/putMessage/{name}")
    public ResponseEntity<String> putMessage(@PathVariable String name) {
        String message = "How's going on, " + name;
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
