package com.employee_management_system.mapper;

import com.employee_management_system.dto.DepartmentDto;
import com.employee_management_system.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
              departmentDto.getId(),
              departmentDto.getName(),
              departmentDto.getDescription()
        );
    }

    public static DepartmentDto mapToDepartmentDto (Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }
}
