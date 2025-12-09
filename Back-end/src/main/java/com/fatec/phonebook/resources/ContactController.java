package com.fatec.phonebook.resources;

import com.fatec.phonebook.dtos.ContactDTO;
import com.fatec.phonebook.entities.Contact;
import com.fatec.phonebook.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok(contactService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Contact> create(@Valid @RequestBody ContactDTO dto) {
        Contact contact = contactService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(
            @PathVariable Long id, 
            @Valid @RequestBody ContactDTO dto) {
        Contact contact = contactService.update(id, dto);
        return ResponseEntity.ok(contact);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }
}