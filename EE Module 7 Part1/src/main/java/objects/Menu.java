package objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "MENU_NAME")
    private String name;
    /*@ManyToMany
    @JoinTable(
            name = "DISHES_IN_MENU",
            joinColumns = @JoinColumn(name = "DISH_ID")
    )
    private List<Integer> dishes;*/



    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
