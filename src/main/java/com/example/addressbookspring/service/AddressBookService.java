package com.example.addressbookspring.service;
import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.entity.AddressBook;
import com.example.addressbookspring.repository.IAddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

        @Autowired
        IAddressBookRepository iAddressBookRepository;
        @Override
        public AddressBook addPerson (AddressBookDTO addressbookDTO){

            AddressBook addressBook = new AddressBook(addressbookDTO);
            return iAddressBookRepository.save(addressBook);
        }

        @Override
        public List<AddressBook> getAddressBook () {
            return iAddressBookRepository.findAll();
        }

        @Override
        public Optional<AddressBook> getById ( int id){
            return iAddressBookRepository.findById(id);
        }

        @Override
        public String deleteById ( int id){
            if (iAddressBookRepository.findById(id).isPresent()) {
                iAddressBookRepository.deleteById(id);
                return "Employee ID: " + id + " is Deleted!";
            }
            return "Employee not present!";
        }

        @Override
        public String editEmployee (AddressBookDTO employeeDto, int id){
            if (iAddressBookRepository.findById(id).isPresent()) {
                AddressBook person = new AddressBook(employeeDto, id);
                person.setId(id);
                AddressBook string = iAddressBookRepository.save(person);
                return string.toString();
            }
            return null;
        }
        @Override
        public List<AddressBook> getPersonByCity (String city){
            return iAddressBookRepository.findByCity(city);
        }
    }

