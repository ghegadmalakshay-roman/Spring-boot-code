package com.mindcraft.model;


import com.mindcraft.entity.Employee;
import com.mindcraft.requestDTO.EmployeeRequest;
import com.mindcraft.responseDTO.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final ModelMapper modelMapper;
    
    

    public EmployeeMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	public Employee mapToEntity(EmployeeRequest request) {
        return modelMapper.map(request, Employee.class);
    }

    public EmployeeResponse mapToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeResponse.class);
    }
}
