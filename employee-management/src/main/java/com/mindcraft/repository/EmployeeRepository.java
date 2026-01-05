package com.mindcraft.repository;

import java.util.*;
import com.mindcraft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmpId(String empId);

/*    List<Employee> findByEmpIdContainingIgnoreCaseOrEmpNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String empId,
            String empName,
            String email
    );*/

    @Query("""
       SELECT e FROM Employee e
       WHERE LOWER(e.empId) LIKE LOWER(CONCAT('%', :search, '%'))
          OR LOWER(e.empName) LIKE LOWER(CONCAT('%', :search, '%'))
          OR LOWER(e.email) LIKE LOWER(CONCAT('%', :search, '%'))
       """)
    List<Employee> searchEmployees(@Param("search") String search);


}
