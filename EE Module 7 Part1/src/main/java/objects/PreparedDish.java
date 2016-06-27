package objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "PREPARED_DISHES")
public class PreparedDish {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "dish_id")
    private int dishId;
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "date")
    private Date date;

    public PreparedDish(int id, int dishId, int employeeId, int orderId, Date date) {
        this.id = id;
        this.dishId = dishId;
        this.employeeId = employeeId;
        this.orderId = orderId;
        this.date = date;
    }

    public PreparedDish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", employeeId=" + employeeId +
                ", orderId=" + orderId +
                ", date=" + date +
                '}';
    }
}
