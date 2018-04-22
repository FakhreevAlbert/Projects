package ru.eidos.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "imageUrl")
    private String imageUrl;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employeeList = new ArrayList<>();

    @OneToOne(mappedBy = "department")

    @JsonIgnore
    Manager manager;

    public Department() {
    }

    public Department(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;

    }
}
