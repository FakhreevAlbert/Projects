package ru.eidos.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "position")
    private String position;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "likes")
    private int likes;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
     private Department department;

    public Employee() {
    }

    public Employee(String name, String lastname, String position,
                    String dateOfBirth, String phoneNumber, String imageUrl,
                    int likes, Department department) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.likes = likes;
        this.department = department;
    }
}
