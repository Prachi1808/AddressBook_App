package com.example.addressbookspring.service;
import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.entity.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    AddressBook addPerson(AddressBookDTO addressBookDTO);

    List<AddressBook> getAddressBook();

    Optional<AddressBook> getById(int id);

    String deleteById(int id);

    String editEmployee(AddressBookDTO employeeDto, int id);

    List<AddressBook> getPersonByCity(String city);
}