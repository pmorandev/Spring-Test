package com.pmoran.spring.torre.service.impl;

import com.pmoran.spring.torre.exception.custom.DuplicateEmailException;
import com.pmoran.spring.torre.exception.custom.EmployeeNotFoundException;
import com.pmoran.spring.torre.model.EmployeeDTO;
import com.pmoran.spring.torre.model.entity.Employee;
import com.pmoran.spring.torre.repository.EmployeeRepository;
import com.pmoran.spring.torre.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ankit Patel
 * @implNote Implementations All Employee Related Service
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.findByEmail(employeeDTO.getEmail()).isPresent()) {
            throw new DuplicateEmailException(" Employee with " + employeeDTO.getEmail() + " already Present");
        }
        Employee employee = employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO employeeDTO) {
        if (!employeeRepository.findById(employeeID).isPresent()) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeID + " not Present!!");
        }
        if (employeeRepository.findByEmailAndIdNot(employeeDTO.getEmail(), employeeID).isPresent()) {
            throw new DuplicateEmailException(" Employee with " + employeeDTO.getEmail() + " already Present");
        }
        employeeDTO.setId(employeeID);
        Employee employee = employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> fetchAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        TypeToken<List<EmployeeDTO>> typeToken = new TypeToken<List<EmployeeDTO>>() {
        };
        return modelMapper.map(employeeList, typeToken.getType());
    }

    @Override
    public String deleteEmployee(Long employeeID) {
        if (!employeeRepository.findById(employeeID).isPresent()) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeID + " not Present!!");
        }
        employeeRepository.deleteById(employeeID);
        return "Employee with Id" + employeeID + "Delete Success";
    }
}
