package com.employee_management_system.controller;

import com.employee_management_system.dto.DepartmentDto;
import com.employee_management_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
@CrossOrigin("*")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);

        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto department = departmentService.getDepartmentById(id);

        return ResponseEntity.ok(department);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.updateDepartment(id, departmentDto);

        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);

        return ResponseEntity.ok("Department deleted successfully");
    }
}
