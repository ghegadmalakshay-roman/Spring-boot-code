package com.mindcraft.service;


import java.util.List;

import com.mindcraft.requestDTO.EmployeeRequest;
import com.mindcraft.responseDTO.ApiResponse;
import com.mindcraft.responseDTO.EmployeeResponse;

public interface EmployeeService {

    ApiResponse<EmployeeResponse> createEmployee(EmployeeRequest request);

    ApiResponse<List<EmployeeResponse>> getAllEmployees();

    ApiResponse<List<EmployeeResponse>> searchEmployees(String search);



}
