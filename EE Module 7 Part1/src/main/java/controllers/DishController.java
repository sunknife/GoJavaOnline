package controllers;


import daos.DishDao;
import objects.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class DishController {

    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void createDish(Dish dish) {
        dishDao.createDish(dish);
    }

    @Transactional
    public void deleteDish(String name) { dishDao.deleteDish(name); }
    @Transactional
    public Dish findDish(String name) {
        return dishDao.findDish(name);
    }

    @Transactional
    public List<Dish> findAllDishes() {
        return dishDao.findAllDishes();
    }
}
