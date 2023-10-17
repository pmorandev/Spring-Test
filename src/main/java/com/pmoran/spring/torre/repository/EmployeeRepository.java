package com.pmoran.spring.torre.repository;

import com.pmoran.spring.torre.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ankit Patel
 * @implNote Repository Used for Employee Entity Database Operation
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByEmailAndIdNot(String email, Long employeeId);
}
