package ru.eidos.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    private int id;
    private String name;
    private String lastname;
    private String dateOfBirth;
    private String phoneNumber;
    private String imageUrl;
}
