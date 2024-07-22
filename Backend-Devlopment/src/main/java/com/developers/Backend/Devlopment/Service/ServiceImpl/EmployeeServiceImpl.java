package com.developers.Backend.Devlopment.Service.ServiceImpl;

import com.developers.Backend.Devlopment.Dto.EmployeeDto;
import com.developers.Backend.Devlopment.Entity.Employee;
import com.developers.Backend.Devlopment.GlobalExceptionHandler.ResourseNotFoundException;
import com.developers.Backend.Devlopment.Mapper.EmployeeMapper;
import com.developers.Backend.Devlopment.Repository.EmployeeRepository;
import com.developers.Backend.Devlopment.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

       Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourseNotFoundException("Employee is not exists with a given id"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

      List<Employee> employees = employeeRepository.findAll();
      return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
              .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourseNotFoundException("Employee is not exists with a given id"+employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
         employeeRepository.findById(employeeId).orElseThrow(()->
                 new ResourseNotFoundException("Employee is not exists with the given Id"+employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
