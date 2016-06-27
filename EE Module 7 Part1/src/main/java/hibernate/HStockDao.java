package hibernate;


import daos.StockDao;
import objects.Ingredient;
import objects.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HStockDao implements StockDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addIngredient(Stock ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
    }

    @Override
    public void removeIngredient(String name) {
        Stock ingredient = findIngredient(name);
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Override
    public void changeIngredientQuantity(int id, int newQuantity) {
        Stock ingredient = findIngredient(id);
        ingredient.setQuantity(newQuantity);
        sessionFactory.getCurrentSession().update(ingredient);
    }

    @Override
    public Stock findIngredient(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Ingredient o where o.name like :name");
        query.setParameter("name",name);
        Ingredient ingredient = (Ingredient) query.uniqueResult();
        query = session.createQuery("select o from Stock o where o.id = :id");
        query.setParameter("id",ingredient.getId());
        return (Stock) query.uniqueResult();
    }


    @Override
    public List<Stock> findAllIngredients() {
        return sessionFactory.getCurrentSession().createQuery("select o from Stock o").list();
    }

    @Override
    public List<Stock> findAllThatEnds(int quantity) {
        return sessionFactory.getCurrentSession().createQuery("select o from Stock o where o.quantity <= :quantity").setParameter("quantity",quantity).list();
    }

    public Stock findIngredient(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Stock o where o.id = :id");
        query.setParameter("id",id);
        return (Stock) query.uniqueResult();
    }
}
