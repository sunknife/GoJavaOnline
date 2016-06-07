package daos;

import objects.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbcEmployeeDao implements EmployeeDao {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createEmployee(Employee employee) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?)");
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getName());
            statement.setDate(4, employee.getBirthDate());
            statement.setString(5, employee.getTelephoneNumber());
            statement.setInt(6, employee.getPositionID());
            statement.setDouble(7, employee.getSalary());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(String surname, String name) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE SURNAME = ? AND NAME = ?");
            statement.setString(1, surname);
            statement.setString(2, name);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee searchForEmployee(String surname, String name) {
        Employee result = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE SURNAME = ? AND NAME = ?");
            statement.setString(1, surname);
            statement.setString(2, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = getEmployeeFromQuery(resultSet);
            } else {
                throw new RuntimeException("There is no employee " + name + " " + surname + " in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(getEmployeeFromQuery(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Employee getEmployeeFromQuery(ResultSet resultSet) throws SQLException {
        return new Employee(resultSet.getInt("id"), resultSet.getString("surname"), resultSet.getString("name"), resultSet.getDate("birth_date"), resultSet.getString("telephone"), resultSet.getInt("position_id"), resultSet.getDouble("salary"));
    }
}
;