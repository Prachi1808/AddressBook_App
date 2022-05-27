package com.example.addressbookspring.repository;
import com.example.addressbookspring.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressBookRepository extends JpaRepository<AddressBook, Integer> {
    @Query(value = "SELECT * FROM address_book e, city ed WHERE e.id = ed.id AND ed.citys = :city",nativeQuery = true)
    List<AddressBook> findByCity(String city);
}

