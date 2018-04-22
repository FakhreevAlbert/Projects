package ru.eidos.backend;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.entity.Manager;
import ru.eidos.backend.repository.ManagerRepository;

import java.util.List;

public class ManagerUnitServiceTest {
    @Autowired
    ManagerRepository managerRepository;

    @Test
    public void testFindAll(){
        ManagerRepository managerRepository = Mockito.mock(ManagerRepository.class);
        Mockito.when(managerRepository.findAll())
                .thenReturn(
                        List.of(new Manager("Ivan" ,"Ivanov", "12.03.1977", "+7(901)111-08-88", "url", (new Department("NewName","Url"))))
                );
        Mockito.verify(
                managerRepository,
                Mockito.times(0)
        ).findAll();

        Assertions.assertEquals(1, managerRepository.findAll().size());


    }

}
