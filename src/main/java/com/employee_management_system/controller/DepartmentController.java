package com.employee_management_system.controller;

import com.employee_management_system.dto.DepartmentDto;
import com.employee_management_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
