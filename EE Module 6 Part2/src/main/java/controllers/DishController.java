package controllers;

import daos.DishDao;
import objects.Dish;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishController {
    private PlatformTransactionManager txManager;
    private DishDao dishDao;

    @Transactional
    public void createDish(Dish dish) {dishDao.createDish(dish);}

    @Transactional
    public void deleteDish(String name){dishDao.deleteDish(name);}

    @Transactional
    public Dish findDish(String name) {return dishDao.findDish(name);}

    @Transactional
    public List<Dish> findAllDishes() {return dishDao.findAllDishes();}

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
