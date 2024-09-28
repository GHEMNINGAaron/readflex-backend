package com.example.groupe2.readflex.models.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String username;
    private String email;
    private boolean isAdmin;


    public UserDto() {}
    public UserDto(String username, String email, boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.isAdmin = isAdmin;
    }


    public boolean isAdmin() {
        return isAdmin;
    }


    public void setStatus(boolean status) {
        isAdmin = status;
    }
}
