package service;


import dao.DishDao;
import model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishService {
    private DishDao dishDao;

    @Transactional
    public Dish getDishByName(String dishName) {
        return dishDao.findDish(dishName);
    }

    @Transactional
    public List<Dish> getAllDishes(){return dishDao.findAllDishes();}

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void deleteDish(String deleteDishName) {
        dishDao.deleteDish(deleteDishName);
    }

    @Transactional
    public void deleteIngredient(int dishId, int ingredientId) {
        dishDao.deleteIngredient(dishId,ingredientId);
    }

    @Transactional
    public Dish getDishById(int dishId) {
        return dishDao.findDish(dishId);
    }

    @Transactional
    public void addNewDish(Dish newDish) {
        dishDao.createDish(newDish);
    }

    @Transactional
    public void addIngredient(int dishId, String ingredientName, int ingredientQuantity) {
        dishDao.addIngredient(dishId,ingredientName,ingredientQuantity);
    }
}
