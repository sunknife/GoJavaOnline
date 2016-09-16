package service;

import dao.StockDao;
import model.Ingredient;
import model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StockService {
    private StockDao stockDao;

    @Transactional
    public List<Stock> whatInStock(){return stockDao.findAllIngredients();}

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Transactional
    public void deleteIngredient(int deleteIngredientId) {
        stockDao.removeIngredient(deleteIngredientId);
    }

    @Transactional
    public void updateIngredient(int updateId, int value) {
        stockDao.changeIngredientQuantity(updateId,value);
    }

    @Transactional
    public void addNewIngredient(Ingredient ingredient) {
        stockDao.addIngredient(ingredient);

    }

    @Transactional
    public void addIngredientInStock(Stock stock) {
        stockDao.addIngredient(stock);
    }
}
