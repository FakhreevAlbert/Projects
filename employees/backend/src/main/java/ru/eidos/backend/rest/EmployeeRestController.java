package ru.eidos.backend.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.eidos.backend.annotation.AuthenticationAccount;
import ru.eidos.backend.dto.EmployeeDTO;
import ru.eidos.backend.entity.Account;
import ru.eidos.backend.entity.Employee;
import ru.eidos.backend.service.EmployeeService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation("get employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("get employee by id")

    public Employee findById(@PathVariable int id, @AuthenticationAccount Account account){
        return employeeService.findById(id);
    }

    @PostMapping("/{id}")
    @ApiOperation("add employee")
    public void add(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){

        employeeService.save(id, employeeDTO);
    }

      @PutMapping("/{id}/{depId}")
      @ApiOperation("update employee")
      public void update(@PathVariable int id, @PathVariable int depId, @RequestBody EmployeeDTO employeeDTO){
          employeeService.update(id, depId, employeeDTO);
      }

    @DeleteMapping("/{id}")
    @ApiOperation("delete employee by id")
    public void deleteById(@PathVariable int id){
        employeeService.deleteById(id);
    }

    @PostMapping("/{id}/likes")
    @ApiOperation("add likes")
    public void like(@PathVariable int id){
        employeeService.like(id);
    }

    @DeleteMapping("/{id}/likes")
    @ApiOperation("delete likes")
    public void dislike(@PathVariable int id){
        employeeService.dislike(id);
    }


    @GetMapping("/{findword}/find")
    @ApiOperation("find by name and lastname")
    public List<Employee> findByNameAndLastname(@PathVariable String findword){
        return employeeService.findAllByNameAndLastname(findword);
    }





}
