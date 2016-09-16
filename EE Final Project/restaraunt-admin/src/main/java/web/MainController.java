package web;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import service.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

@Controller(value = "/")
public class MainController {
    private MenuService menuService;
    private EmployeeService employeeService;
    private OrderService orderService;
    private DishService dishService;
    private StockService stockService;

    @RequestMapping(value = "/")
    public String index(Map<String,Object> model){
        return "index";
    }

    @RequestMapping(value = "/dish")
    public String dish(Map<String,Object> model){
        model.put("dishes", dishService.getAllDishes());
        return "dish";
    }

    @RequestMapping(value = "/dish", params = "deleteDishName",method = RequestMethod.POST)
    public String deleteDish(Map<String,Object> model,@RequestParam String deleteDishName){
        dishService.deleteDish(deleteDishName);
        model.remove("dishes");
        model.put("dishes", dishService.getAllDishes());
        return "dish";
    }

    @RequestMapping(value = "/dish",params = "addDish",method = RequestMethod.POST)
    public String addDish(Map<String,Object> model,@RequestParam String addDish, WebRequest request){
        int dishId = Integer.valueOf(request.getParameter("dishId"));
        String dishName = request.getParameter("dishName");
        String dishCategory = request.getParameter("dishCategory");
        Double dishCost = Double.valueOf(request.getParameter("dishCost"));
        int dishWeight = Integer.valueOf(request.getParameter("dishWeight"));
        Dish newDish = new Dish(dishId,dishName,dishCategory,dishCost,dishWeight);
        dishService.addNewDish(newDish);
        model.remove("dishes");
        model.put("dishes", dishService.getAllDishes());
        return "dish";
    }

    @RequestMapping(value = "/dishEdit",params = "dishName",method = RequestMethod.POST)
    public String dishEdit(Map<String,Object> model,@RequestParam String dishName){
        model.put("dish", dishService.getDishByName(dishName));
        model.put("allIngredients", stockService.whatInStock());
        return "dishEdit";
    }

    @RequestMapping(value = "/dishEdit",params = {"dishId","deleteFromDish"}, method = RequestMethod.POST)
    public String deleteFromDish(Map<String,Object> model,@RequestParam int dishId,@RequestParam int deleteFromDish){
        dishService.deleteIngredient(dishId, deleteFromDish);
        model.put("allIngredients", stockService.whatInStock());
        model.put("dish", dishService.getDishById(dishId));
        return "dishEdit";
    }

    @RequestMapping(value = "/dishEdit",params = {"addIngredient","dishId"}, method = RequestMethod.POST)
    public String addToDish(Map<String,Object> model,@RequestParam String addIngredient,@RequestParam int dishId, WebRequest request){
        String ingredientName = request.getParameter("availableIngredients");
        int ingredientQuantity = Integer.valueOf(request.getParameter("ingredientQuantity"));
        dishService.addIngredient(dishId, ingredientName, ingredientQuantity);
        model.put("dish", dishService.getDishById(dishId));
        model.put("allIngredients", stockService.whatInStock());
        return "dishEdit";
    }

    @RequestMapping(value = "/dish/{dishName}")
    @ResponseBody
    public Dish jdish(Map<String,Object> model, @PathVariable String dishName){
        return dishService.getDishByName(dishName);
    }

    @RequestMapping(value = "/stock")
    public String stock(Map<String,Object> model){
        model.put("ingredients", stockService.whatInStock());
        return "stock";
    }

    @RequestMapping(value = "/stock",params = "deleteIngredientId",method = RequestMethod.POST)
    public String deleteIngredient(Map<String,Object> model,@RequestParam int deleteIngredientId){
        stockService.deleteIngredient(deleteIngredientId);
        model.remove("ingredients");
        model.put("ingredients", stockService.whatInStock());
        return "stock";
    }

    @RequestMapping(value = "/stock",params = "updateId",method = RequestMethod.POST)
    public String updateIngredient(Map<String,Object> model,@RequestParam int updateId, WebRequest request){
        int value = Integer.valueOf(request.getParameter(Integer.toString(updateId)));
        stockService.updateIngredient(updateId, value);
        model.remove("ingredients");
        model.put("ingredients", stockService.whatInStock());
        return "stock";
    }

    @RequestMapping(value = "/stock",params = "addNew",method = RequestMethod.POST)
    public String addIngredient(Map<String,Object> model,@RequestParam String addNew, WebRequest request){
        int id  = Integer.valueOf(request.getParameter("ingredientId"));
        String name = request.getParameter("ingredientName");
        int quantity = Integer.valueOf(request.getParameter("ingredientQuantity"));
        Ingredient ingredient = new Ingredient(id,name);
        Stock stock = new Stock(id,quantity);
        stockService.addNewIngredient(ingredient);
        stockService.addIngredientInStock(stock);
        model.remove("ingredients");
        model.put("ingredients", stockService.whatInStock());
        return "stock";
    }


    @RequestMapping(value = "/employee")
    public String employees(Map<String,Object> model){
        model.put("employees", employeeService.getAllEmployees());
        return "employee";
    }

    @RequestMapping(value = "/employee",params = "updateId",method = RequestMethod.POST)
    public String updateEmployee(Map<String,Object> model,@RequestParam int updateId, WebRequest request){
        int position = Integer.valueOf(request.getParameter("employeePosition"));
        String name = request.getParameter("employeeName");
        String surname = request.getParameter("employeeSurname");
        java.sql.Date date = Date.valueOf(request.getParameter("employeeBirth"));
        String telephone = request.getParameter("employeeTelephone");
        Double salary = Double.valueOf(request.getParameter("employeeSalary"));
        Employee employee = new Employee(updateId,surname,name,date,telephone,position,salary);
        employeeService.updateEmployee(employee);
        model.remove("employees");
        model.put("employees", employeeService.getAllEmployees());
        return "employee";
    }

    @RequestMapping(value = "/employee",params = "addNew",method = RequestMethod.POST)
    public String addEmployee(Map<String,Object> model,@RequestParam String addNew, WebRequest request){
        int id = Integer.valueOf(request.getParameter("employeeId"));
        int position = Integer.valueOf(request.getParameter("employeePosition"));
        String name = request.getParameter("employeeName");
        String surname = request.getParameter("employeeSurname");
        java.sql.Date date = Date.valueOf(request.getParameter("employeeBirth"));
        String telephone = request.getParameter("employeeTelephone");
        Double salary = Double.valueOf(request.getParameter("employeeSalary"));
        Employee employee = new Employee(id,surname,name,date,telephone,position,salary);
        employeeService.addNewEmployee(employee);
        model.remove("employees");
        model.put("employees", employeeService.getAllEmployees());
        return "employee";
    }

    @RequestMapping(value = "/employee/{employeeName}.{employeeSurname}")
    @ResponseBody
    public Employee employeeJson(Map<String,Object> model, @PathVariable String employeeName, @PathVariable String employeeSurname){
        return employeeService.findEmployee(employeeSurname,employeeName);
    }


    @RequestMapping(value = "/menu")
    public String menus(Map<String,Object> model){
        model.put("menus", menuService.getAllMenus());
        return "menu";
    }

    @RequestMapping(value = "/menu",params = "deleteMenuName",method = RequestMethod.POST)
    public String deletemenu(Map<String,Object> model,@RequestParam String deleteMenuName){
        menuService.deleteMenu(deleteMenuName);
        model.remove("menus");
        model.put("menus", menuService.getAllMenus());
        return "menu";
    }


    @RequestMapping(value = "/menu", params = "addMenu",method = RequestMethod.POST)
    public String addMenu(Map<String,Object> model,@RequestParam String addMenu, WebRequest request){
        int menuId = Integer.valueOf(request.getParameter("menuId"));
        String menuName = request.getParameter("menuName");
        Menu newMenu = new Menu(menuId,menuName);
        menuService.addNewMenu(newMenu);
        model.remove("menus");
        model.put("menus", menuService.getAllMenus());
        return "menu";
    }


    @RequestMapping(value = "/menuEdit",params = "menuName",method = RequestMethod.POST)
    public String editmenu(Map<String,Object> model,@RequestParam String menuName){
        model.put("allDishes",dishService.getAllDishes());
        model.put("menu",menuService.findMenu(menuName));
        return "menuEdit";
    }

    @RequestMapping(value = "/menuEdit", params = {"deleteDishFromMenu","menuId"},method = RequestMethod.POST)
    public String deleteFromMenu(Map<String,Object> model,@RequestParam int deleteDishFromMenu,@RequestParam int menuId){
        menuService.deleteFromMenu(menuId,deleteDishFromMenu);
        model.put("allDishes",dishService.getAllDishes());
        model.remove("menu");
        model.put("menu",menuService.findMenu(menuId));
        return "menuEdit";
    }

    @RequestMapping(value = "/menuEdit", params = {"addDishToMenu","menuId"},method = RequestMethod.POST)
    public String addToMenu(Map<String,Object> model, @RequestParam String addDishToMenu, @RequestParam int menuId, WebRequest request ){
        model.put("allDishes",dishService.getAllDishes());
        String dishName = request.getParameter("availableDishes");
        model.put("test",dishName);
        menuService.addToMenu(dishName, menuId);
        model.remove("menu");
        model.put("menu",menuService.findMenu(menuId));
        return "menuEdit";
    }

    @RequestMapping(value = "/menu/{menuName}")
    @ResponseBody
    public Menu menu(Map<String,Object> model, @PathVariable String menuName){
        return menuService.findMenu(menuName);
    }

    @RequestMapping(value = "/order")
    public String orders(Map<String,Object> model){
        model.put("orders", orderService.findAll());
        return "order";
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String filter(Map<String,Object> model, @RequestParam String filter, WebRequest request){
        String filterName = request.getParameter("filterName");
        String filterValue = request.getParameter("filterValue");
        if (filterName.equals("Date")) {
            model.put("orders", filterByDate(orderService.findAll(),filterValue));
        } else if (filterName.equals("Waiter")) {
            model.put("orders", filterByWaiter(orderService.findAll(),filterValue));
        } else if (filterName.equals("Table"))
            model.put("orders", filterByTable(orderService.findAll(),filterValue));
        return "order";
    }

    private List<Order> filterByTable(List<Order> collection, String filterValue) {
        List<Order> result = new ArrayList<>();
        for(Order order: collection){
            if (order.getTableNumber()==Integer.valueOf(filterValue)){
                result.add(order);
            }
        }
        return result;
    }

    private List<Order> filterByWaiter(List<Order> collection, String filterValue) {
        List<Order> result = new ArrayList<>();
        for(Order order: collection){
            if (order.getEmployeeId()==Integer.valueOf(filterValue)){
                result.add(order);
            }
        }
        return result;
    }

    private List<Order> filterByDate(List<Order> collection, String filterValue) {
        List<Order> result = new ArrayList<>();
        for(Order order: collection){
            if (order.isOpen());
        }
        return result;
    }

    @RequestMapping(value = "/order/open")
    @ResponseBody
    public List<Order> openOrders(Map<String,Object> model){
        return orderService.findOpenOrders();
    }

    @RequestMapping(value = "/order/closed")
    @ResponseBody
    public List<Order> closedOrders(Map<String,Object> model){
        return orderService.findClosedOrders();
    }


    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }
}
