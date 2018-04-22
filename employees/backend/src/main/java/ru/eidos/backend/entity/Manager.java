package ru.eidos.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "imageUrl")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public Manager(String name, String lastname, String dateOfBirth, String phoneNumber, String imageUrl, Department department) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.department = department;
    }
}
