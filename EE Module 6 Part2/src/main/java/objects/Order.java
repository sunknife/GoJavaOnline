package objects;


import java.util.Map;

public class Order {
    private int id;
    private int employeeId;
    private int tableNumber;
    private boolean isOpen;
    private Map<Integer, Integer> orderedDishes;

    public Order(int id, int employeeId, int tableNumber, boolean isOpen) {
        this.id = id;
        this.employeeId = employeeId;
        this.tableNumber = tableNumber;
        this.isOpen = isOpen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Map<Integer, Integer> getOrderedDishes() {
        return orderedDishes;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", tableNumber=" + tableNumber +
                ", isOpen=" + isOpen +
                ", orderedDishes=" + orderedDishes +
                '}';
    }

    public void setOrderedDishes(Map<Integer, Integer> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
}
