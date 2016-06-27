package controllers;


import daos.OrderDao;
import objects.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderController implements OrderDao{
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Transactional
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    @Transactional
    public void addDishToOrder(int orderId, int dishId, int quantity) {

    }

    @Transactional
    public void removeDishFromOrder(int orderID, int dishId) {

    }

    @Transactional
    public void closeOrder(int id) {
        orderDao.closeOrder(id);
    }

    @Transactional
    public List<Order> findAllOpenOrders() {
        return orderDao.findAllOpenOrders();
    }

    @Transactional
    public List<Order> findAllClosedOrders() {
        return orderDao.findAllClosedOrders();
    }
}
