package service;

import dao.MenuDao;
import model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {
    private MenuDao menuDao;


    @Transactional
    public List<Menu> getAllMenus(){
        return menuDao.findAllMenus();
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }




    @Transactional
    public Menu findMenu(String menuName) {
        return menuDao.findMenu(menuName);
    }

    @Transactional
    public void deleteMenu(String menuName) {
        menuDao.deleteMenu(menuName);
    }

    @Transactional
    public void deleteFromMenu(int menuId, int deleteDishFromMenu) {
        menuDao.removeDishFromMenu(deleteDishFromMenu,menuId);
    }

    @Transactional
    public Menu findMenu(int menuId) {
        return menuDao.findMenu(menuId);
    }

    @Transactional
    public void addToMenu(String addDishToMenu, int menuId) {
        menuDao.addDishToMenu(addDishToMenu,menuId);
    }

    @Transactional
    public void addNewMenu(Menu newMenu) {
        menuDao.createMenu(newMenu);
    }
}
