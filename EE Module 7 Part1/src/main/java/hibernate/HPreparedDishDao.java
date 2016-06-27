package hibernate;


import daos.PreparedDishDao;
import objects.PreparedDish;
import org.hibernate.SessionFactory;

import java.util.List;

public class HPreparedDishDao implements PreparedDishDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPreparedDish(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().save(preparedDish);
    }

    @Override
    public List<PreparedDish> findAllPreparedDishes() {
        return sessionFactory.getCurrentSession().createQuery("select d from PreparedDish d").list();
    }
}
