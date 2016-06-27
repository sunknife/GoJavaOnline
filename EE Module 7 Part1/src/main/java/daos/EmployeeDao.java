package daos;

import objects.Employee;

import java.util.List;


public interface EmployeeDao {
    void createEmployee(Employee employee);

    void deleteEmployee(String surname, String name);

    Employee searchForEmployee(String surname, String name);

    List<Employee> findAll();
}
