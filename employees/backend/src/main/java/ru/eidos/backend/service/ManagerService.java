package ru.eidos.backend.service;

import ru.eidos.backend.dto.ManagerDTO;
import ru.eidos.backend.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> findAll();

    Manager findById(int id);

    void add(int id, ManagerDTO managerDTO);

    void delete(int id);

    void update(int id,int depId, ManagerDTO managerDTO);
}
