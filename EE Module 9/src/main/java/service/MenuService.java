package service;

import dao.DishDao;
import dao.MenuDao;
import model.Dish;
import model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {
    private MenuDao menuDao;
    private DishDao dishDao;

    @Transactional
    public List<Menu> getAllMenus(){
        return menuDao.findAllMenus();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public Dish getDishByName(String dishName) {
        return dishDao.findDish(dishName);
    }
}
