package objects;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    List<PreparedDish> cookedDishes;

    public List<PreparedDish> getCookedDishes() {
        return cookedDishes;
    }

    public void setCookedDishes(List<PreparedDish> cookedDishes) {
        this.cookedDishes = cookedDishes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Cook{");
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
        result.append(", cookedDishes=");
        result.append(cookedDishes);
        result.append('}');
        return result.toString();
    }
}
