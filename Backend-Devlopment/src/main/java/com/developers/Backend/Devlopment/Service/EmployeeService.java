package com.developers.Backend.Devlopment.Service;

import com.developers.Backend.Devlopment.Dto.EmployeeDto;
import java.util.List;


public interface EmployeeService {



     EmployeeDto createEmployee(EmployeeDto employeeDto);

     EmployeeDto getEmployeeById(Long employeeId);

     List<EmployeeDto> getAllEmployees();

     EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

     void deleteEmployee(Long employeeId);



}
