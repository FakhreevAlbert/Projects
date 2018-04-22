package ru.eidos.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eidos.backend.dto.ManagerDTO;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Manager;
import ru.eidos.backend.exception.DepartmentNotFoundException;
import ru.eidos.backend.exception.ManagerBadRequestExeption;
import ru.eidos.backend.exception.ManagerNotFounException;
import ru.eidos.backend.repository.DepartmentRepository;
import ru.eidos.backend.repository.ManagerRepository;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final DepartmentRepository departmentRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository, DepartmentRepository departmentRepository) {
        this.managerRepository = managerRepository;
        this.departmentRepository = departmentRepository;
    }
    @Transactional
    @Override
    public List<Manager> findAll(){
        return managerRepository.findAll();
    }
    @Transactional
    @Override
    public Manager findById(int id){
        return managerRepository.findById(id).orElseThrow(ManagerNotFounException::new);
    }
    @Transactional
    @Override
    public void add(int id, ManagerDTO managerDTO){
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        List<Manager> managers = managerRepository.findAllByDepartment(department);
        if(managers.size()>0){
            throw new ManagerBadRequestExeption("У данного отдела уже есть менеджер");
        }
        Manager newManager = new Manager(managerDTO.getName(), managerDTO.getLastname(), managerDTO.getDateOfBirth(),
                managerDTO.getPhoneNumber(), managerDTO.getImageUrl(), department);
        managerRepository.save(newManager);
    }

    @Transactional
    @Override
    public void delete(int id){
        managerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(int id, int depId, ManagerDTO managerDTO) {
    Manager manager = managerRepository.findById(id).orElseThrow(ManagerNotFounException::new);
    Department department = departmentRepository.findById(depId).orElseThrow(DepartmentNotFoundException::new);
    List<Manager> managers = managerRepository.findAllByDepartment(department);
    Manager newManager = managers.get(0);
    if(newManager.getId()!= manager.getId()){
        throw new ManagerBadRequestExeption("У данного отдела уже есть менеджер");
    }

    manager.setName(managerDTO.getName());
    manager.setLastname(managerDTO.getLastname());
    manager.setDateOfBirth(managerDTO.getDateOfBirth());
    manager.setPhoneNumber(managerDTO.getPhoneNumber());
    manager.setImageUrl(managerDTO.getImageUrl());
    manager.setDepartment(department);



    }
}
