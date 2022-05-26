package com.example.addressbookspring.entity;
import com.example.addressbookspring.dto.AddressBookDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String profilePic;

    private String gender;
    private String mobileNumber;
    private String email;

    private String address;

    @ElementCollection
    @CollectionTable(name = "city", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "citys")
    private List<String> city;
    private LocalDate dob;
    private String notes;

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.profilePic = addressBookDTO.getProfilePic();
        this.gender = addressBookDTO.getGender();
        this.mobileNumber = addressBookDTO.getMobileNumber();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.dob =addressBookDTO.getDob();
        this.notes = addressBookDTO.getNotes();
    }

    public  AddressBook(AddressBookDTO addressBookDTO, int id) {
        this.name = addressBookDTO.getName();
        this.profilePic = addressBookDTO.getProfilePic();
        this.gender =addressBookDTO.getGender();
        this.mobileNumber =addressBookDTO.getMobileNumber();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.dob = addressBookDTO.getDob();
        this.notes = addressBookDTO.getNotes();
        this.id = id;
    }
}

