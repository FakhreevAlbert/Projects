package ru.eidos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eidos.backend.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{







}
