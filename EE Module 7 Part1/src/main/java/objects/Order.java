package objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "TABLE_NUMBER")
    private int tableNumber;
    @Column(name = "IS_OPEN")
    private boolean isOpen;
    /*@ManyToMany()
    @JoinTable(
            name = "ORDERED_DISHES",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "QUANTITY")
    )
    private Map<Integer, Integer> orderedDishes;*/

    public Order(int id, int employeeId, int tableNumber, boolean isOpen) {
        this.id = id;
        this.employeeId = employeeId;
        this.tableNumber = tableNumber;
        this.isOpen = isOpen;
    }

    public Order() {
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


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", tableNumber=" + tableNumber +
                ", isOpen=" + isOpen +
                '}';
    }
}
