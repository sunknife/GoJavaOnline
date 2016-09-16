package dao;


import model.PreparedDish;

import java.util.List;

public interface PreparedDishDao {
    void addPreparedDish(PreparedDish preparedDish);
    List<PreparedDish> findAllPreparedDishes();
}
