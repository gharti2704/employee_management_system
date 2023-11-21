package com.employee_management_system.service.implementation;

import com.employee_management_system.dto.DepartmentDto;
import com.employee_management_system.entity.Department;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.mapper.DepartmentMapper;
import com.employee_management_system.repository.DepartmentRepository;
import com.employee_management_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist with the given id: " + id));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist with the given id: " + id));

        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());

        Department updateDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updateDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist with the given id: " + id));

        departmentRepository.delete(department);
    }
}
