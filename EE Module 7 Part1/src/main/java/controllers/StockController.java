package controllers;

import daos.StockDao;
import objects.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StockController {
    private StockDao stockDao;

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Transactional
    public void addIngredient(Stock ingredient) {
        stockDao.addIngredient(ingredient);
    }

    @Transactional
    public void removeIngredient(String name) {
        stockDao.removeIngredient(name);
    }

    @Transactional
    public void changeIngredientQuantity(int id, int newQuantity) {
        stockDao.changeIngredientQuantity(id,newQuantity);
    }

    @Transactional
    public Stock findIngredient(String name) {
        return stockDao.findIngredient(name);
    }

    @Transactional
    public List<Stock> findAllIngredients() {
        return stockDao.findAllIngredients();
    }

    @Transactional
    public List<Stock> findAllThatEnds(int quantity) {
        return stockDao.findAllThatEnds(quantity);
    }
}
