package controllers;


import daos.DishDao;
import daos.PreparedDishDao;
import daos.StockDao;
import objects.Dish;
import objects.Ingredient;
import objects.PreparedDish;
import objects.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PreparedDishController {
    private PreparedDishDao preparedDishDao;
    private DishDao dishDao;
    private StockDao stockDao;

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;

    }

    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }

    @Transactional
    public void addPreparedDish(PreparedDish preparedDish) {
        Dish dish=dishDao.findDish(preparedDish.getDishId());
        List<Ingredient> ingredients = dish.getIngredients();
        if (ingredientsValidator(ingredients)) {
            for (Ingredient ingredient : ingredients) {
                stockDao.changeIngredientQuantity(ingredient.getId(), -1);
            }
            preparedDishDao.addPreparedDish(preparedDish);
        }
    }
    @Transactional
    private boolean ingredientsValidator(List<Ingredient> ingredients) {
        for (Ingredient ingredient:ingredients){
            Stock currentStock = stockDao.findIngredient(ingredient.getName());
            if (currentStock.getQuantity()==0) return false;
        }
        return true;
    }


    @Transactional
    public List<PreparedDish> findAllPreparedDishes() {
        return preparedDishDao.findAllPreparedDishes();
    }
}
