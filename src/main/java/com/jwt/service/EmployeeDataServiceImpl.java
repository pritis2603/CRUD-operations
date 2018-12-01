package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.jwt.dao.EmployeeDataDAO;
import com.jwt.model.EmployeData;
 
@Service
public class EmployeeDataServiceImpl implements EmployeeDataService {
 
    @Autowired
    private EmployeeDataDAO employeeDAO;
 
    @Override
    @Transactional
    public void addEmployee(EmployeData employee) {
       employeeDAO.addEmployee(employee);
    }
 
    @Override
    @Transactional
    public List<EmployeData> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

	@Override
    @Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}

	@Override
    @Transactional
	public EmployeData getEmployee(int employeeid) {
		
		return employeeDAO.getEmployee(employeeid);
	}

	@Override
    @Transactional
	public EmployeData updateEmployee(EmployeData employee) {
	
		return employeeDAO.updateEmployee(employee);
	}
}
