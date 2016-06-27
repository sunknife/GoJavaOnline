package controllers;

import daos.MenuDao;
import objects.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Slava on 24/06/2016.
 */
public class MenuController {
    private MenuDao menuDao;

    @Transactional
    public void createMenu(Menu menu) {
        menuDao.createMenu(menu);
    }

    @Transactional
    public void deleteMenu(String name) {
        menuDao.deleteMenu(name);
    }

    @Transactional
    public void addDishToMenu(String dishName, int menuID) {

    }

    @Transactional
    public void removeDishFromMenu(int dishID, int menuId) {

    }

    @Transactional
    public Menu findMenu(String name) {
        return menuDao.findMenu(name);
    }

    @Transactional
    public List<Menu> findAllMenus() {
        return menuDao.findAllMenus();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
