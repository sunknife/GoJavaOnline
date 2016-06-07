package objects;


public class Stock {
    public Stock(int ingredientId, int quantity) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }

    private int ingredientId;
    private int quantity;

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

    @Override
    public String toString() {
        return "Stock{" +
                "ingredientId=" + ingredientId +
                ", quantity=" + quantity +
                '}';
    }
}
