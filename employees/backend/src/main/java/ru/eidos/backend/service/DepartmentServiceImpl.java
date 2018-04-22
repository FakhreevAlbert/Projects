package ru.eidos.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eidos.backend.dto.DepartmentDTO;
import ru.eidos.backend.dto.EmployeeDTO;
import ru.eidos.backend.dto.ManagerDTO;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Employee;
import ru.eidos.backend.entity.Manager;
import ru.eidos.backend.exception.DepartmentBadRequestExeption;
import ru.eidos.backend.exception.DepartmentNotFoundException;
import ru.eidos.backend.repository.DepartmentRepository;
import ru.eidos.backend.repository.EmployeeRepository;
import ru.eidos.backend.repository.ManagerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ManagerRepository managerRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
    }
    @Transactional
    @Override
    public List<Department>  findAll(){
        return departmentRepository.findAll();
    }
    @Transactional
    @Override
    public Department findById(int id){
        return departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
    }
    @Transactional
    @Override
    public void save(DepartmentDTO departmentDTO){

        if(departmentDTO.getName().length() < 3){
            throw new IllegalArgumentException("name is too short");
        }
        Department department = new Department(departmentDTO.getName(), departmentDTO.getImageUrl());
        departmentRepository.save(department);
    }
    @Transactional
    @Override
    public void deleteById(int id){
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        List<Manager> managers = managerRepository.findAllByDepartment(department);
        if(managers.size() > 0){
            throw new DepartmentBadRequestExeption("Перед удалением отдела, удалите из списка менеджера этого отдела");
        }

        departmentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(int id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        department.setName(departmentDTO.getName());
        department.setImageUrl(departmentDTO.getImageUrl());

    }

    @Transactional
    @Override
    public List<EmployeeDTO> findAllEmployees(int id) {
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        List<Employee>records= employeeRepository.findAllByDepartment(department);

            return records.stream().map(record ->
                    new EmployeeDTO(
                            record.getId(),
                            record.getName(),
                            record.getLastname(),
                            record.getPosition(),
                            record.getDateOfBirth(),
                            record.getPhoneNumber(),
                            record.getImageUrl(),
                            record.getLikes()
                    )).collect(Collectors.toList());

    }
    @Transactional
    @Override
    public List<ManagerDTO> findManager(int id) {
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        List<Manager> records = managerRepository.findAllByDepartment(department);

        return records.stream().map(record->
        new ManagerDTO(
                record.getId(),
                record.getName(),
                record.getLastname(),
                record.getDateOfBirth(),
                record.getPhoneNumber(),
                record.getImageUrl()
        )).collect(Collectors.toList());
    }
}
