package hibernate;


import dao.StockDao;
import model.Ingredient;
import model.Stock;
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
    public void addIngredient(Stock stock) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createNativeQuery("INSERT INTO STOCK VALUES (?,?);");
        query.setParameter(1, stock.getIngredientId());
        query.setParameter(2, stock.getQuantity());
        query.executeUpdate();
    }

    @Override
    public void removeIngredient(String name) {
        Stock ingredient = findIngredient(name);
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Override
    public void removeIngredient(int id) {
        Stock ingredient = findIngredient(id);
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

    @Override
    public void addIngredient(Ingredient ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
    }

    public Stock findIngredient(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Stock o where o.id = :id");
        query.setParameter("id",id);
        return (Stock) query.uniqueResult();
    }

    @Override
    public Ingredient searchForIngredient(int id) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.query.Query query = session.createQuery("select o from Ingredient o where o.id = :id");
        query.setParameter("id",id);
        return (Ingredient) query.uniqueResult();
    }
}
