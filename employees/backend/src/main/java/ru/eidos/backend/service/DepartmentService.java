package ru.eidos.backend.service;

import ru.eidos.backend.dto.DepartmentDTO;
import ru.eidos.backend.dto.EmployeeDTO;
import ru.eidos.backend.dto.ManagerDTO;
import ru.eidos.backend.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(int id);

    void save(DepartmentDTO departmentDTO);

    void deleteById(int id);

    void update(int id, DepartmentDTO departmentDTO);

    List<EmployeeDTO> findAllEmployees(int id);

   List <ManagerDTO> findManager(int id);
}
