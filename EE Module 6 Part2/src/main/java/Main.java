import controllers.*;
import objects.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private MenuController menuController;
    private OrderController orderController;
    private PreparedDishController preparedDishController;
    private StockController stockController;

    public void setStockController(StockController stockController) {
        this.stockController = stockController;
    }

    public void setPreparedDishController(PreparedDishController preparedDishController) {
        this.preparedDishController = preparedDishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    public void start() {
        //Here you can use any interface for getting work all classes.

        /*List<Employee> result;
        result = employeeController.findAll();
        if (result == null) System.out.println("Bad!");
        else
        result.forEach(System.out::println);*/

        //employeeController.createEmployee(new Employee(4,"Pupkin","Vasya",new java.sql.Date(1988,9,14),"+380445555555",3,10000.0));
        //employeeController.deleteEmployee("Pupkin", "Vasya");
        //System.out.println(employeeController.searchForEmployee("Pupkin", "Vasya"));
        //System.out.println(dishController.findDish("Omelete"));
        //dishController.deleteDish("bomblet");
        //dishController.findAllDishes().forEach(System.out::println);
        /*Dish bomblet = new Dish(2,"bomblet","Breakfast",40.5,300);
        Map<Integer,Double> dishIngredients = new HashMap<>();
        dishIngredients.put(1,4.0);
        dishIngredients.put(2,0.2);
        bomblet.setIngredients(dishIngredients);
        System.out.println(bomblet);
        dishController.createDish(bomblet);
        System.out.println(dishController.findDish("bomblet"));*/
        /*Menu babaka = new Menu(2,"Babaka");
        List<Integer> dishes = new ArrayList<>();
        dishes.add(1);
        babaka.setDishes(dishes);
        menuController.createMenu(babaka);*/
        //menuController.deleteMenu("Babaka");
        //menuController.addDishToMenu("Omelete",1);
        //menuController.findAllMenus().forEach(System.out::println);
        //System.out.println(menuController.findMenu("Breakfast Menu"));
        /*Order vipTable = new Order(3,3,4,true);
        Map<Integer,Integer> dishes = new HashMap<>();
        dishes.put(1,3);
        vipTable.setOrderedDishes(dishes);
        orderController.createOrder(vipTable);*/
        //orderController.deleteOrder(3);
        //orderController.findAllOpenOrders().forEach(System.out::println);
        //preparedDishController.addPreparedDish(new PreparedDish(3,1,2,1,new java.sql.Date(2016,05,20)));
        //preparedDishController.findAllPreparedDishes().forEach(System.out::println);
        //System.out.println(stockController.findIngredient("Egg"));
        //stockController.findAllIngredients().forEach(System.out::println);


    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
}
