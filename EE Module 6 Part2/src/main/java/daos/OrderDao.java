package daos;

import objects.Order;

import java.util.List;

public interface OrderDao {
    void createOrder(Order order);
    void deleteOrder(int id);
    void addDishToOrder(int orderId, int dishId, int quantity);
    void removeDishFromOrder(int orderID, int dishId);
    void closeOrder(int id);
    List<Order> findAllOpenOrders();
    List<Order> findAllClosedOrders();


}
