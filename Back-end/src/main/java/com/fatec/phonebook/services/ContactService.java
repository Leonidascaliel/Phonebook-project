package com.fatec.phonebook.services;

import com.fatec.phonebook.dtos.ContactDTO;
import com.fatec.phonebook.entities.Contact;
import com.fatec.phonebook.entities.Group;
import com.fatec.phonebook.repositories.ContactRepository;
import com.fatec.phonebook.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private GroupRepository groupRepository;
    
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
    
    public Contact findById(Long id) {
        return contactRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }
    
    @Transactional
    public Contact create(ContactDTO dto) {
        // Busca o grupo no banco
        Group group = groupRepository.findById(dto.getGroupId())
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com ID: " + dto.getGroupId()));
        
        // Cria o contato
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setTelephone(dto.getTelephone());
        contact.setEmail(dto.getEmail());
        contact.setAddress(dto.getAddress());
        contact.setState(dto.getState());
        contact.setZipcode(dto.getZipcode());
        contact.setGroup(group);
        
        return contactRepository.save(contact);
    }
    
    @Transactional
    public Contact update(Long id, ContactDTO dto) {
        // Busca o contato existente
        Contact contact = findById(id);
        
        // Busca o grupo no banco
        Group group = groupRepository.findById(dto.getGroupId())
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com ID: " + dto.getGroupId()));
        
        // Atualiza os campos
        contact.setName(dto.getName());
        contact.setTelephone(dto.getTelephone());
        contact.setEmail(dto.getEmail());
        contact.setAddress(dto.getAddress());
        contact.setState(dto.getState());
        contact.setZipcode(dto.getZipcode());
        contact.setGroup(group);
        
        return contactRepository.save(contact);
    }
    
    @Transactional
    public void delete(Long id) {
        Contact contact = findById(id);
        contactRepository.delete(contact);
    }
}