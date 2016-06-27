package hibernate;


import daos.EmployeeDao;
import objects.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public void deleteEmployee(String surname, String name) {
        Employee employee = searchForEmployee(surname,name);
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public Employee searchForEmployee(String surname, String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name and e.surname like :surname");
        query.setParameter("name",name);
        query.setParameter("surname", surname);
        return (Employee) query.uniqueResult();
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select o from Employee o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
