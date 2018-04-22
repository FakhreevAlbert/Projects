package ru.eidos.backend.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.eidos.backend.dto.DepartmentDTO;
import ru.eidos.backend.dto.EmployeeDTO;
import ru.eidos.backend.dto.ManagerDTO;
import ru.eidos.backend.entity.Department;
import ru.eidos.backend.service.DepartmentService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {
    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @ApiOperation("find all departments")
    public List<Department> findAll(){
    return departmentService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("find by id")
    public Department getById(@PathVariable int id){
        return departmentService.findById(id);
    }

    @PostMapping()
    @ApiOperation("add department")
    public void add(@RequestBody DepartmentDTO department) {
        departmentService.save(department);
    }

      @PutMapping("/{id}")
      @ApiOperation("update department")
      public void update(@PathVariable int id, @RequestBody DepartmentDTO departmentDTO){
          departmentService.update(id, departmentDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete by id")
    public void delete(@PathVariable int id){
        departmentService.deleteById(id);
    }

    @GetMapping("/{id}/employees")
    @ApiOperation("get list employees by department id")
    public List<EmployeeDTO> findAll(@PathVariable int id){
        return departmentService.findAllEmployees(id) ;
    }

    @GetMapping("/{id}/manager")
    @ApiOperation("get manager by by department id")
    public List<ManagerDTO> findManager(@PathVariable int id){
        return departmentService.findManager(id);
    }


}
