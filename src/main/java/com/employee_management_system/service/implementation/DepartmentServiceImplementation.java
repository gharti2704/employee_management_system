package com.employee_management_system.service.implementation;

import com.employee_management_system.dto.DepartmentDto;
import com.employee_management_system.entity.Department;
import com.employee_management_system.mapper.DepartmentMapper;
import com.employee_management_system.repository.DepartmentRepository;
import com.employee_management_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
