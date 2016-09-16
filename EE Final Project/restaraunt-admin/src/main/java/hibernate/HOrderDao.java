package hibernate;


import dao.OrderDao;
import model.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HOrderDao implements OrderDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.id = :id");
        query.setParameter("id",id);
        Order order = (Order) query.uniqueResult();
        session.delete(order);
    }

    @Override
    public void addDishToOrder(int orderId, int dishId, int quantity) {

    }

    @Override
    public void removeDishFromOrder(int orderID, int dishId) {

    }

    @Override
    public void closeOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Order o set o.isOpen = :false where o.id = :id");
        query.setParameter("false",false);
        query.setParameter("id",id);
        query.executeUpdate();

    }

    @Override
    public List<Order> findAllOpenOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.isOpen = :true");
        query.setParameter("true",true);
        return query.list();
    }

    @Override
    public List<Order> findAllClosedOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.isOpen = :false");
        query.setParameter("false",false);
        return (List<Order>)query.list();
    }
}
