package com.jwt.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.jwt.model.EmployeData;
 
@Repository
public class EmployeeDataDAOImpl implements EmployeeDataDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addEmployee(EmployeData employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<EmployeData> getAllEmployees() {
 
        return sessionFactory.getCurrentSession().createQuery("from EmployeData")
                .list();
    }
    @Override
    public void deleteEmployee(Integer employeeId) {
        EmployeData employee = (EmployeData) sessionFactory.getCurrentSession().load(
                EmployeData.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
 
    }
 
    public EmployeData getEmployee(int empid) {
        return (EmployeData) sessionFactory.getCurrentSession().get(
                EmployeData.class, empid);
    }
 
    @Override
    public EmployeData updateEmployee(EmployeData employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
 
}
