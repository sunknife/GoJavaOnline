package web;

import model.Employee;
import model.Menu;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.EmployeeService;
import service.MenuService;
import service.OrderService;

import java.util.List;
import java.util.Map;

@Controller(value = "/")
public class MainController {
    private MenuService menuService;
    private EmployeeService employeeService;
    private OrderService orderService;

    @RequestMapping(value = "/")
    public String index(Map<String,Object> model){
        model.put("menus",menuService.getAllMenus());
        return "index";
    }

    @RequestMapping(value = "/dish")
    public String dish(@RequestParam("dishName") String dishName, Map<String,Object> model){
        model.put("dish", menuService.getDishByName(dishName));
        return "dish";
    }

    @RequestMapping(value = "/scheme")
    public String scheme(Map<String,Object> model){
        return "scheme";
    }

    @RequestMapping(value = "/employees")
    public String employees(Map<String,Object> model){
        model.put("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @RequestMapping(value = "/employee")
    @ResponseBody
    public List<Employee> employeesJson(Map<String,Object> model){
        model.put("employees", employeeService.getAllEmployees());
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{employeeName}.{employeeSurname}")
    @ResponseBody
    public Employee employeeJson(Map<String,Object> model, @PathVariable String employeeName, @PathVariable String employeeSurname){
        return employeeService.findEmployee(employeeSurname,employeeName);
    }

    @RequestMapping(value = "/contacts")
    public String contacts(Map<String,Object> model){
        return "contacts";
    }

    @RequestMapping(value = "/menu")
    @ResponseBody
    public List<Menu> menus(Map<String,Object> model){
        return menuService.getAllMenus();
    }

    @RequestMapping(value = "/menu/{menuName}")
    @ResponseBody
    public Menu menu(Map<String,Object> model, @PathVariable String menuName){
        return menuService.findMenu(menuName);
    }

    @RequestMapping(value = "/order")
    @ResponseBody
    public List<Order> orders(Map<String,Object> model){
        return orderService.findAll();
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
}
