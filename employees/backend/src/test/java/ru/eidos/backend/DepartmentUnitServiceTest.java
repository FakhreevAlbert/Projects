package ru.eidos.backend;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import ru.eidos.backend.dto.DepartmentDTO;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.exception.DepartmentNotFoundException;
import ru.eidos.backend.repository.DepartmentRepository;
import ru.eidos.backend.repository.EmployeeRepository;
import ru.eidos.backend.repository.ManagerRepository;
import ru.eidos.backend.service.DepartmentService;
import ru.eidos.backend.service.DepartmentServiceImpl;

import java.util.List;

public class DepartmentUnitServiceTest {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ManagerRepository managerRepository;

    @Test
   public void testFindAll() {
        DepartmentRepository departmentRepository = Mockito.mock(DepartmentRepository.class);
        Mockito.when(departmentRepository.findAll())
                .thenReturn(
                        List.of(
                                new Department("Станочный", "http://met-all.org/wp-content/uploads/2016/02/shirokoformatnyy-chpu-1213.jpg"),
                                new Department("Литейный","https://trashbox.ru/files/528970_ff9e29/3dprint.jpg_min1.jpg")

                        )
                );
        DepartmentService departmentService = new DepartmentServiceImpl (departmentRepository,
                managerRepository,
                employeeRepository
        );

        Mockito.verify(
                departmentRepository,
                Mockito.times(0)
        ).findAll();

        Assertions.assertEquals(2, departmentService.findAll().size());


    }



    @Test
    public void testThrowsException() {
        DepartmentRepository departmentRepository =
                Mockito.mock(DepartmentRepository.class);


        DepartmentService departmentService = new DepartmentServiceImpl(
                departmentRepository,
                managerRepository,
                employeeRepository
        );

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.save(new DepartmentDTO("te", "departmentUrl"))
        );

        Assertions.assertThrows(DepartmentNotFoundException.class,
                () -> departmentService.findById(1000));


    }
}
