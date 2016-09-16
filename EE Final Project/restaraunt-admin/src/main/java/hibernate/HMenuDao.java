package hibernate;


import dao.MenuDao;
import model.Dish;
import model.Menu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HMenuDao implements MenuDao {
    private SessionFactory sessionFactory;

    @Override
    public void createMenu(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void deleteMenu(String name) {
        Menu menu = findMenu(name);
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    public void addDishToMenu(String dishName, int menuID) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createQuery("select e from Dish e where e.name like :name");
        query.setParameter("name", dishName);
        Dish dish = (Dish) query.uniqueResult();
        query = session.createNativeQuery("INSERT INTO DISHES_IN_MENU VALUES (?,?);");
        query.setParameter(1, dish.getId());
        query.setParameter(2, menuID);
        query.executeUpdate();
    }

    @Override
    public void removeDishFromMenu(int dishID, int menuId) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createNativeQuery("delete from DISHES_IN_MENU where dish_id = ? and menu_id= ?");
        query.setParameter(1, dishID);
        query.setParameter(2, menuId);
        query.executeUpdate();
    }

    @Override
    public Menu findMenu(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Menu e where e.name like :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    public List<Menu> findAllMenus() {
        return sessionFactory.getCurrentSession().createQuery("select o from Menu o").list();
    }

    @Override
    public Menu findMenu(int menuId) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createQuery("select e from Menu e where e.id = :id");
        query.setParameter("id", menuId);
        return (Menu) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
