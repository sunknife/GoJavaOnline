package service;


import dao.EmployeeDao;
import model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
