package com.addressbookapp.AddressBookAppDevelopment.repository;

import com.addressbookapp.AddressBookAppDevelopment.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

//Created AddressRepository extending JpaRepository so that we perform CURD and can implement custom query methods
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
