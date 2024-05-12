package com.luv2code.springboot.ThymeleafEmployees.dao;

import com.luv2code.springboot.ThymeleafEmployees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
