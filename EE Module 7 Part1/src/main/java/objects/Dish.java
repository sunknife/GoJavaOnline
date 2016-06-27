package objects;


import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "cost")
    private double cost;
    @Column(name = "weight")
    private int weight;

    /*@ManyToMany
    @JoinTable(
            name = "DISH_INGREDIENTS",
            joinColumns = @JoinColumn(name = "INGREDIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "QUANTITY")
    )*/
    //private Map<Integer, Double> ingredients;
    public Dish(int id, String name, String category, double cost, int weight) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.weight = weight;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
