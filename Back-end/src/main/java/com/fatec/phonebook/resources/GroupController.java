package com.fatec.phonebook.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.fatec.phonebook.entities.Group;
import com.fatec.phonebook.services.GroupService;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    @Autowired
    private GroupService service;

    @GetMapping
    public List<Group> getGroups() {
        return service.getGroups();
    }

    @GetMapping("{id}")
    public Group getGroupById(@PathVariable Long id) {
        return service.getGroupById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGroupById(@PathVariable Long id) {
        service.deleteGroupById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Group> saveGroup(@Valid @RequestBody Group group) {
        Group newGroup = service.saveGroup(group);
        return ResponseEntity.ok(newGroup);
    }

    @PutMapping("{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @Valid @RequestBody Group updated) {
        Group existing = service.getGroupById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        Group saved = service.saveGroup(existing);
        return ResponseEntity.ok(saved);
    }
}

