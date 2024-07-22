package com.developers.Backend.Devlopment.Controller;


import com.developers.Backend.Devlopment.Dto.EmployeeDto;
import com.developers.Backend.Devlopment.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Build add Employee Rest Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

       EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
       return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get employees by EmployeeId Rest Api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employee);
    }

    //Build Get all Employees Rest Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){

       EmployeeDto updateEmployee =  employeeService.updateEmployee(employeeId,updatedEmployee);
       return ResponseEntity.ok(updateEmployee);
    }

    //Build the delete employee Rest Api

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
