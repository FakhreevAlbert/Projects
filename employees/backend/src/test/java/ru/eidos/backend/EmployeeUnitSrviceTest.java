package ru.eidos.backend;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Employee;
import ru.eidos.backend.repository.EmployeeRepository;

import java.util.List;

public class EmployeeUnitSrviceTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testFindAll(){
        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
        Mockito.when(employeeRepository.findAll())
                .thenReturn(
                        List.of(new Employee("Timur" ,"Zotov", "Токарь", "12.03.1977","+7(901)111-08-99","url", 0, (new Department("NewName","Url"))))
                );
        Mockito.verify(
                employeeRepository,
                Mockito.times(0)
        ).findAll();

        Assertions.assertEquals(1, employeeRepository.findAll().size());

    }
}
