package dao;



import model.Ingredient;
import model.Stock;

import java.util.List;

public interface StockDao {
    void addIngredient(Stock stock);
    void removeIngredient(String name);
    void removeIngredient(int id);
    void changeIngredientQuantity(int id, int newQuantity);
    Stock findIngredient(String name);
    Stock findIngredient(int id);
    Ingredient searchForIngredient(int id);
    List<Stock> findAllIngredients();
    List<Stock> findAllThatEnds(int quantity);

    void addIngredient(Ingredient ingredient);
}