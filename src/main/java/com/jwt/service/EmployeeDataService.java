

package com.jwt.service;

import java.util.List;
 
import com.jwt.model.EmployeData;
 
public interface EmployeeDataService {
     
    public void addEmployee(EmployeData employee);
 
    public List<EmployeData> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public EmployeData getEmployee(int employeeid);
 
    public EmployeData updateEmployee(EmployeData employee);
}
