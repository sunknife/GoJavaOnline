package controllers;

import daos.EmployeeDao;
import objects.Employee;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeController {
    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(String surname, String name) {
        employeeDao.deleteEmployee(surname, name);
    }

    @Transactional
    public Employee searchForEmployee(String surname, String name) {
        return employeeDao.searchForEmployee(surname, name);
    }

    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
