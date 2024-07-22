package com.developers.Backend.Devlopment.Mapper;

import com.developers.Backend.Devlopment.Dto.EmployeeDto;
import com.developers.Backend.Devlopment.Entity.Employee;

public class EmployeeMapper {

    public static Employee maptoEmployee(EmployeeDto employeeDto){

       return  new Employee(
               employeeDto.getId(),
               employeeDto.getFirstName(),
               employeeDto.getLastName(),
               employeeDto.getEmail()
       );
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
