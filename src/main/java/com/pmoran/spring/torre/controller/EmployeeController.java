package com.pmoran.spring.torre.controller;

import com.pmoran.spring.torre.api.EmployeeAPI;
import com.pmoran.spring.torre.model.EmployeeDTO;
import com.pmoran.spring.torre.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ankit Patel
 * @implNote Employee related API
 */
@RestController
public class EmployeeController implements EmployeeAPI {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.fetchAllEmployee(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO.getName());
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
