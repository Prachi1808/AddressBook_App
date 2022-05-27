package com.example.addressbookspring.controller;
import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.dto.ResponseDTO;
import com.example.addressbookspring.entity.AddressBook;
import com.example.addressbookspring.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
    @RestController
    @RequestMapping("/addressbook")
    public class AddressBookController {
        @Autowired
        IAddressBookService iAddressBookService;

        /**
         * post mapping request method to create contact
         * adding an employee and saving to DB using post mapping and taking the input by RequestBody
        */
        @PostMapping("/adding")
        public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody AddressBookDTO addressBookDTO) {
            AddressBook id = iAddressBookService.addPerson(addressBookDTO);
            ResponseDTO responseDTO = new ResponseDTO("Employee added Successfully", id);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }

        /**getting all the employee and showing in a list from the DB using get mapping
         */
        @GetMapping("/showall")
        public ResponseEntity<ResponseDTO> getAllEmployees() {
            ResponseDTO responseDTO = new ResponseDTO("Employee List shown Bellow", iAddressBookService.getAddressBook());
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        /**getting the employee with a particular id from the DB and showing using get mapping
        */
        @GetMapping("/show/{id}")
        public ResponseEntity<ResponseDTO> getByEmployee(@PathVariable int id) {
            ResponseDTO responseDTO = new ResponseDTO("Employee with id " + id + " Shown bellow", iAddressBookService.getById(id));
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        /**deleting the employee with a particular id from the DB using Delete mapping
         */
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
            ResponseDTO responseDTO = new ResponseDTO("Employee with id " + id + " Deleted Successfully", iAddressBookService.deleteById(id));
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        /**getting the employee with a particular id from the DB and updating the data and storing to DB using put mapping
         */
        @PutMapping("/edit/{id}")
        public ResponseEntity<ResponseDTO> editEmployee(@Valid @RequestBody AddressBookDTO employeeDto, @PathVariable int id) {
            ResponseDTO responseDTO = new ResponseDTO("Employee with id " + id + " Updated Successfully", iAddressBookService.editEmployee(employeeDto, id));
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        @GetMapping("/city/{city}")
        public ResponseEntity<ResponseDTO> getPersonByCity(@PathVariable String city){
            List<AddressBook> personList = iAddressBookService.getPersonByCity(city);
            ResponseDTO responseDTO = new ResponseDTO("employee list gotten successfully",personList);
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
    }


