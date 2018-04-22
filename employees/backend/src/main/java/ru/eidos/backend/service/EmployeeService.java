package ru.eidos.backend.service;

import ru.eidos.backend.dto.EmployeeDTO;
import ru.eidos.backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void save(int id, EmployeeDTO employeeDTO);

    void deleteById(int id);

    void like(int id);

    void dislike(int id);

    void update(int id, int depId, EmployeeDTO employeeDTO);
    String wordToUpperCase(String findword);

    List<Employee> findAllByName(String name);

    List<Employee> findAllByLastname(String lastname);

    List<Employee> findAllByNameAndLastname(String findword);



}
