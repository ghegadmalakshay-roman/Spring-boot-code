package com.mindcraft.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mindcraft.requestDTO.EmployeeRequest;
import com.mindcraft.responseDTO.ApiResponse;
import com.mindcraft.responseDTO.EmployeeResponse;

import com.mindcraft.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    

    public EmployeeController(EmployeeService employeeService) {
	
		this.employeeService = employeeService;
	}

	@PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(
            @RequestBody EmployeeRequest request) {

        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> searchEmployees(
            @RequestParam String search) {

        return ResponseEntity.ok(employeeService.searchEmployees(search));
    }


  
}
