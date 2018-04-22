package ru.eidos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @Modifying
    @Transactional
    List<Manager> findAllByDepartment(Department department);


}
