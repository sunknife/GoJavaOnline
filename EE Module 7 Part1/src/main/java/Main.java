import controllers.*;
import objects.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private DishController dishController;
    private EmployeeController employeeController;
    private MenuController menuController;
    private OrderController orderController;
    private StockController stockController;
    private PreparedDishController preparedDishController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml","hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        //Dish eggs = new Dish(3,"Egg","Breakfast",30.5,100);
        //dishController.createDish(eggs);
        //System.out.println(dishController.findDish("Egg"));
        //dishController.deleteDish("Egg");
        //dishController.findAllDishes().forEach(System.out::println);

        //employeeController.deleteEmployee("Biz","Bazizi");
        //employeeController.findAll().forEach(System.out::println);
        //menuController.createMenu(new Menu(2,"Abra"));
        //menuController.deleteMenu("Abra");
        //menuController.findAllMenus().forEach(System.out::println);
        //orderController.closeOrder(4);
        //orderController.deleteOrder(4);
        //orderController.findAllClosedOrders().forEach(System.out::println);
        //stockController.addIngredient(new Stock(1,9));
        //stockController.removeIngredient("Egg");
        //stockController.changeIngredientQuantity(1,7);
        //stockController.findAllIngredients().forEach(System.out::println);
        //System.out.println(stockController.findIngredient("Egg"));
        preparedDishController.addPreparedDish(new PreparedDish(3,1,3,2,new Date(2016,06,27)));
        //preparedDishController.findAllPreparedDishes().forEach(System.out::println);
        /*Waiter lola = new Waiter();
        lola.setName("Lola");
        lola.setSurname("Mahina");
        lola.setBirthDate(new Date(2000,12,12));
        lola.setId(4);
        lola.setPositionID(2);
        lola.setSalary(23000.0);
        lola.setTelephoneNumber("+380441111111");
        employeeController.createEmployee(lola);
        orderController.createOrder(new Order(4,4,3,true));*/
        //employeeController.printAllEmployees();
        //dishController.findAllDishes().forEach(System.out::println);

    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setPreparedDishController(PreparedDishController preparedDishController) {
        this.preparedDishController = preparedDishController;
    }

    public void setStockController(StockController stockController) {
        this.stockController = stockController;

    }
}
