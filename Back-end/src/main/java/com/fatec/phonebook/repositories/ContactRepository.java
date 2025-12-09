package com.fatec.phonebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.phonebook.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
  
}
