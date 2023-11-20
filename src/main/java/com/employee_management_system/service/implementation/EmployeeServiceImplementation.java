package com.employee_management_system.service.implementation;

import com.employee_management_system.dto.EmployeeDto;
import com.employee_management_system.entity.Employee;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.mapper.EmployeeMapper;
import com.employee_management_system.repository.EmployeeRepository;
import com.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    // employeeRepository dependency injection
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // map employeeDto to employee jpa data entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // save employee to db
        Employee savedEmployee = employeeRepository.save(employee);

        // map back to employeeDto and return
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
         Employee employee = employeeRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with the given id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

        // Lambda expression with method reference
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }
}
