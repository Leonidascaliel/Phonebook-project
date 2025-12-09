package com.fatec.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import com.fatec.phonebook.entities.Group;
import com.fatec.phonebook.repositories.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repository;
    
    public List<Group> getGroups() {
        return repository.findAll();
    }

    public Group getGroupById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Grupo não encontrado."));
    }

    public void deleteGroupById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Grupo não existente.");
        }
    }

    public Group saveGroup(Group group) {
        return repository.save(group);
    }
}
