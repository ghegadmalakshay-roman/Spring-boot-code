package com.mindcraft.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mindcraft.entity.Employee;
import com.mindcraft.exception.BaseException;
import com.mindcraft.model.EmployeeMapper;
import com.mindcraft.repository.EmployeeRepository;
import com.mindcraft.requestDTO.EmployeeRequest;
import com.mindcraft.responseDTO.ApiResponse;
import com.mindcraft.responseDTO.EmployeeResponse;
import com.mindcraft.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public ApiResponse<EmployeeResponse> createEmployee(EmployeeRequest request) {

        if (employeeRepository.existsByEmpId(request.getEmpId())) {
            throw new BaseException("Employee already exists with empId : " + request.getEmpId());
        }

        Employee employee = employeeMapper.mapToEntity(request);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponse response = employeeMapper.mapToDto(savedEmployee);

        return new ApiResponse<>(
                "SUCCESS",
                "Employee created successfully",
                response
        );
    }

    @Override
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new BaseException("EMP_404", "No employees found", HttpStatus.NOT_FOUND);
        }

        List<EmployeeResponse> responseList = employees.stream()
                .map(employeeMapper::mapToDto)
                .collect(Collectors.toList());

        return new ApiResponse<>(
                "SUCCESS",
                "Employee list fetched successfully",
                responseList
        );
    }

    @Override
    public ApiResponse<List<EmployeeResponse>> searchEmployees(String search) {

        List<Employee> employees = employeeRepository.searchEmployees(search);

        if (employees.isEmpty()) {
            throw new BaseException(
                    "EMP_404",
                    "No employee found for search keyword : " + search,
                    HttpStatus.NOT_FOUND
            );
        }

        List<EmployeeResponse> responseList = employees.stream()
                .map(employeeMapper::mapToDto)
                .collect(Collectors.toList());

        return new ApiResponse<>(
                "SUCCESS",
                "Employee search result",
                responseList
        );
    }
}
