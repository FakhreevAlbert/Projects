package ru.eidos.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eidos.backend.dto.EmployeeDTO;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Employee;
import ru.eidos.backend.exception.DepartmentNotFoundException;
import ru.eidos.backend.exception.EmployeeNotFoundException;
import ru.eidos.backend.repository.DepartmentRepository;
import ru.eidos.backend.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    @Transactional
    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    @Transactional
    @Override
    public Employee findById(int id){

        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }
    @Transactional
    @Override
    public void save(int id, EmployeeDTO employeeDTO){
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        
        Employee newEmployee = new Employee(employeeDTO.getName(), employeeDTO.getLastname(),
                employeeDTO.getPosition(), employeeDTO.getDateOfBirth(),  employeeDTO.getPhoneNumber(),
                employeeDTO.getImageUrl(),employeeDTO.getLikes(), department);

        employeeRepository.save(newEmployee);

    }

    @Transactional
    @Override
    public void update(int id, int depId, EmployeeDTO employeeDTO){
        Department department = departmentRepository.findById(depId).orElseThrow(DepartmentNotFoundException::new);
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

        employee.setName(employeeDTO.getName());
        employee.setLastname(employeeDTO.getLastname());
        employee.setPosition(employeeDTO.getPosition());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setImageUrl(employeeDTO.getImageUrl());
        employee.setLikes(employeeDTO.getLikes());
        employee.setDepartment(department);

    }

    @Override
    public List<Employee> findAllByName(String name) {

        return employeeRepository.findAllByName(name);
    }

    @Override
    public List<Employee> findAllByLastname(String lastname) {
        return employeeRepository.findAllByLastname(lastname);
    }

    @Override
    public String wordToUpperCase(String findword){

        if(findword == null || findword.isEmpty()) return "";
        return findword.substring(0, 1).toUpperCase() + findword.substring(1);
    }

    @Transactional
    @Override
    public List<Employee> findAllByNameAndLastname(String findword) {
        String toUpperCasefindWord = wordToUpperCase(findword);

        List<Employee> result = new ArrayList<>();
        result = findAllByName(toUpperCasefindWord);
        if (result.size() == 0){
            result = findAllByLastname(toUpperCasefindWord);
        }
        return result;
    }


    @Transactional
    @Override
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

    @Override
    public void like(int id){
        employeeRepository.like(id);
    }

    @Override
    public void dislike(int id){
        employeeRepository.dislike(id);
    }







}
