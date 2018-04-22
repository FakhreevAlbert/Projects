package ru.eidos.backend.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.eidos.backend.dto.ManagerDTO;
import ru.eidos.backend.entity.Manager;
import ru.eidos.backend.service.ManagerService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/managers")
public class ManagerRestController {

    private final ManagerService managerService;

    public ManagerRestController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    @ApiOperation("get all managers")
    public List<Manager> findAll(){
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("get manager by id")
    public Manager findById(@PathVariable int id){
        return managerService.findById(id);
    }

    @PostMapping("/{id}")
    @ApiOperation("add manager")
    public void add(@PathVariable int id, @RequestBody ManagerDTO managerDTO){
        managerService.add(id, managerDTO);

    }
    @PutMapping("/{id}/{depId}")
    @ApiOperation("update manager")
    public void update(@PathVariable int id, @PathVariable int depId, @RequestBody ManagerDTO managerDTO){
        managerService.update(id, depId, managerDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete manager")
    public void delete(@PathVariable int id){
        managerService.delete(id);
    }


}
