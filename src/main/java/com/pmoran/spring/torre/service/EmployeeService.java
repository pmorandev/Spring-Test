package com.pmoran.spring.torre.service;

import com.pmoran.spring.torre.model.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ankit Patel
 * @implNote Definitions All Employee Related Service
 */
@Service
public interface EmployeeService {

    /**
     * @param employeeDTO
     * @return employeeDTO
     * @implNote Saving New Employee
     */
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    /**
     * @param employeeID
     * @param employeeDTO
     * @return employeeDTO
     * @implNote Update existing employee using ID and other details it will update all data,
     * we can make another method to updated selected fields but for demo I have followed simple
     */
    EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO employeeDTO);

    /**
     * @return List of employeeDTO
     * @implNote For Simple purpose I am fetching ALL data ,we can provide pagination and also with filter,
     * but I have made it simple
     */
    List<EmployeeDTO> fetchAllEmployee();

    /**
     * @param employeeID
     * @return message for delete success
     * @implNote I have implements Hard delete we can do soft delete
     */
    String deleteEmployee(Long employeeID);

}
