package hibernate;

import dao.DishDao;
import model.Dish;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class HDishDao implements DishDao {
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public void createDish(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);

    }

    public void deleteDish(String name) {
        Dish dish = findDish(name);
        sessionFactory.getCurrentSession().delete(dish);
    }

    public Dish findDish(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.name like :name");
        query.setParameter("name",name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public Dish findDish(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.id = :id");
        query.setParameter("id",id);
        return (Dish) query.uniqueResult();
    }

    public List<Dish> findAllDishes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Dish e").list();
    }
}
