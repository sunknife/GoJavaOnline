package daos;

import objects.PreparedDish;

import java.util.List;

public interface PreparedDishDao {
    void addPreparedDish(PreparedDish preparedDish);
    List<PreparedDish> findAllPreparedDishes();
}
