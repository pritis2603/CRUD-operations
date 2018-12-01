package com.jwt.dao;

import java.util.List;

import com.jwt.model.EmployeData;

public interface EmployeeDataDAO {
 
 public void addEmployee(EmployeData e); 
 
    public List<EmployeData> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
  
 
    public EmployeData updateEmployee(EmployeData employee);
 
    public EmployeData getEmployee(int employeeid);
}

