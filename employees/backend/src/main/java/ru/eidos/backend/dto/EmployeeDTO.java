package ru.eidos.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    int id;
    String name;
    String lastname;
    String position;
    String dateOfBirth;
    String phoneNumber;
    String imageUrl;
    int likes;


}
