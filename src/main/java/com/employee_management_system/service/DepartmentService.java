package com.employee_management_system.service;

import com.employee_management_system.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    public DepartmentDto createDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(Long id);
    public List<DepartmentDto> getAllDepartments();
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
    public void deleteDepartment(Long id);
}
