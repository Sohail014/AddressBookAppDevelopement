package com.addressbookapp.AddressBookAppDevelopment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Created ResponseDTO class to get output in format of message with data
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {
    private String message;
    private Object data;

//    public ResponseDTO(String message, Object data) {
//        super();
//        this.message = message;
//        this.data = data;
//    }
}
