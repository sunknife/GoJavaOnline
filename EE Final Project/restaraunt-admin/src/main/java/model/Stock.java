package model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
    public Stock(int ingredientId, int quantity) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }

    @Id
    @Column(name = "INGREDIENT_ID")
    private int ingredientId;
    @Column(name = "QUANTITY")
    private int quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ingredientId=" + ingredientId +
                ", quantity=" + quantity +
                '}';
    }
}
