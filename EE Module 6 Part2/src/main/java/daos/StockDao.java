package daos;

import objects.Stock;

import java.util.List;

public interface StockDao {
    void addIngredient(Stock ingredient);
    void removeIngredient(int id);
    void changeIngredientQuantity(int id, int newQuantity);
    Stock findIngredient(String name);
    List<Stock> findAllIngredients();
    List<Stock> findAllThatEnds(int quantity);

}
