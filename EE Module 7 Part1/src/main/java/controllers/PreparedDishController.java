package controllers;


import daos.PreparedDishDao;
import objects.PreparedDish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PreparedDishController {
    private PreparedDishDao preparedDishDao;

    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }

    @Transactional
    public void addPreparedDish(PreparedDish preparedDish) {
        preparedDishDao.addPreparedDish(preparedDish);
    }

    @Transactional
    public List<PreparedDish> findAllPreparedDishes() {
        return preparedDishDao.findAllPreparedDishes();
    }
}
