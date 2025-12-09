package com.fatec.phonebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.phonebook.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
