package ru.eidos.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.eidos.backend.entity.Account;
import ru.eidos.backend.repository.AccountRepository;
import ru.eidos.backend.repository.DepartmentRepository;
import ru.eidos.backend.repository.EmployeeRepository;
import ru.eidos.backend.repository.ManagerRepository;

import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BackendApplication.class, args);
		{

			EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
			DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
			ManagerRepository managerRepository = context.getBean(ManagerRepository.class);
		}
//		{
//			AccountRepository repository = context.getBean(AccountRepository.class);
//			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
//
//			repository.save(new Account(
//					0,
//					"admin",
//					encoder.encode("password"),
//					List.of(
//							new SimpleGrantedAuthority("VIEW"),
//							new SimpleGrantedAuthority("EDIT")
//					),
//					true,
//					true,
//					true,
//					true
//			));
//		}

	}
}



