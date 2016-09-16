package dao;


import model.Menu;

import java.util.List;

public interface MenuDao {
    void createMenu(Menu menu);
    void  deleteMenu(String name);
    void addDishToMenu(String dishName, int menuID);
    void removeDishFromMenu(int dishID, int menuId);
    Menu findMenu(String name);
    List<Menu> findAllMenus();
}
