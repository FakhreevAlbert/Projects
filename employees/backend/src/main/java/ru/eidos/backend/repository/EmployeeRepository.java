package ru.eidos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


    @Modifying
    @Transactional
    @Query("update Employee e set e.likes = e.likes + 1 where e.id = :id")
    void like(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("update Employee e set e.likes = e.likes - 1 where e.id = :id")
    void dislike(@Param("id") int id);

    @Modifying
    @Transactional
    List<Employee> findAllByDepartment(Department department);

    @Modifying
    @Transactional
    List<Employee> findAllByName(@Param("name") String name);

    @Modifying
    @Transactional
    List<Employee> findAllByLastname(@Param("lastname") String lastname);






}
