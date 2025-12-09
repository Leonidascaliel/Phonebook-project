package com.fatec.phonebook.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactDTO {
    
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    
    @NotBlank(message = "Telefone é obrigatório")
    private String telephone;
    
    @Email(message = "Email inválido")
    private String email;
    
    private String address;
    private String state;
    private String zipcode;
    
    @NotNull(message = "Grupo é obrigatório")
    private Long groupId; // ← Recebe apenas o ID
    
    // Constructors
    public ContactDTO() {}
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public Long getGroupId() {
        return groupId;
    }
    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}