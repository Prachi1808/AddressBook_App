package com.example.addressbookspring.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]+$", message = "Name is invalid! it must have at least 2 characters and the first character should be uppercase.")
    private String name;

    @NotEmpty(message = "Profile pic can't be empty")
    private String profilePic;

    @NotEmpty(message = "Its a required field! can't be empty")
    private String gender;

    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Enter a valid mobile number")
    private String mobileNumber;

    @Email
    private String email;

    @NotEmpty(message = "Please enter the address")
    private String address;

    @ElementCollection
    @CollectionTable(name = "city", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "city")
    private List<String> city;

    private LocalDate dob;
    private String notes;
}


