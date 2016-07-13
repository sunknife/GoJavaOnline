package daos;


import objects.Dish;

import java.util.List;

public interface DishDao {
    void createDish(Dish dish);

    void deleteDish(String name);

    Dish findDish(String name);

    Dish findDish(int id);

    List<Dish> findAllDishes();

}
