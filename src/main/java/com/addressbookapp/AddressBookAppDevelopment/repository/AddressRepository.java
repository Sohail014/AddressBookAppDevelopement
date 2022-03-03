package com.addressbookapp.AddressBookAppDevelopment.repository;

import com.bridgelabz.addressbookapplication.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(value = "select * from address_book where first_name = :first_name", nativeQuery = true)
    public List<Address> findByFirstName(@Param(value = "first_name") String firstName);

    @Query(value = "select * from address_book ", nativeQuery = true)
    public List<Address> findAllData();
}