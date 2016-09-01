package service;

import dao.OrderDao;
import model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    public List<Order> findOpenOrders() {
        return orderDao.findAllOpenOrders();
    }

    @Transactional
    public List<Order> findClosedOrders() {
        return orderDao.findAllClosedOrders();
    }

    @Transactional
    public List<Order> findAll() {
        List<Order> result = new ArrayList<>();
        result.addAll(orderDao.findAllClosedOrders());
        result.addAll(orderDao.findAllOpenOrders());
        result.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getId()>o2.getId()?1:0;
            }
        });
        return result;
    }
}
