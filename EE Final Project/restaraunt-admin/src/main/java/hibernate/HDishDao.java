package hibernate;

import dao.DishDao;
import model.Dish;
import model.Ingredient;
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

    @Override
    public void addIngredient(int dishId, String ingredientName, int ingredientQuantity) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createQuery("select e from Ingredient e where e.name like :name");
        query.setParameter("name", ingredientName);
        Ingredient ingredient = (Ingredient) query.uniqueResult();
        query = session.createNativeQuery("INSERT INTO DISH_INGREDIENTS VALUES (?,?,?);");
        query.setParameter(1, dishId);
        query.setParameter(2, ingredient.getId());
        query.setParameter(3, ingredientQuantity);
        query.executeUpdate();
    }

    @Override
    public void deleteIngredient(int dishId, int ingredientId) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createNativeQuery("delete from DISH_INGREDIENTS where dish_id = ? and INGREDIENT_ID= ?");
        query.setParameter(1, dishId);
        query.setParameter(2, ingredientId);
        query.executeUpdate();
    }
}
