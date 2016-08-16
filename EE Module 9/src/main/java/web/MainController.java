package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmployeeService;
import service.MenuService;

import java.util.Map;

@Controller(value = "/")
public class MainController {
    private MenuService menuService;
    private EmployeeService employeeService;

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


    @RequestMapping(value = "/contacts")
    public String contacts(Map<String,Object> model){
        return "contacts";
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
