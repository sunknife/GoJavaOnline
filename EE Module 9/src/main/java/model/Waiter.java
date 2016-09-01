package model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity
public class Waiter extends Employee {
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Order> orders;



    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Waiter{");
        result.append("id=");
        result.append(this.getId());
        result.append(", surname='");
        result.append(this.getSurname());
        result.append('\'');
        result.append(", name='");
        result.append(this.getName());
        result.append('\'');
        result.append(", birthDate=");
        result.append(this.getBirthDate());
        result.append(", telephoneNumber='");
        result.append(this.getTelephoneNumber());
        result.append('\'');
        result.append(", salary=");
        result.append(this.getSalary());
        result.append(", orders=");
        result.append(orders);
        result.append('}');
        return result.toString();
    }
}
