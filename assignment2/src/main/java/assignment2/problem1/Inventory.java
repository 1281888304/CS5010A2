package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * inventory class of object
 */
public class Inventory {
  private List<StockItem> groceryList;
  private List<StockItem> householdList;

  /**
   * generate two new arraylist
   */
  public Inventory() {
    groceryList=new ArrayList<>();
    householdList=new ArrayList<>();
  }

  /**
   * @return grocery list
   */
  public List<StockItem> getGroceryList() {
    return groceryList;
  }

  /**
   * @return household list
   */
  public List<StockItem> getHouseholdList() {
    return householdList;
  }

  /**
   * @param stockItem stockItem
   */
  public void addStockItem(StockItem stockItem){
    if(stockItem.getProduct() instanceof Grocery){
      groceryList.add(stockItem);
    }else if(stockItem.getProduct() instanceof  Household){
      householdList.add(stockItem);
    }
  }

  /**
   * @return total value of inventory
   */
  public int retailValue(){
    int sum=0;
    for(StockItem stockItem: groceryList){
      sum+=stockItem.getProduct().getPrice();
    }
    for(StockItem stockItem: householdList){
      sum+=stockItem.getProduct().getPrice();
    }
    return sum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Inventory)) {
      return false;
    }

    Inventory inventory = (Inventory) o;

    if (!getGroceryList().equals(inventory.getGroceryList())) {
      return false;
    }
    return getHouseholdList().equals(inventory.getHouseholdList());
  }

  @Override
  public int hashCode() {
    int result = getGroceryList().hashCode();
    result = 31 * result + getHouseholdList().hashCode();
    return result;
  }

  /**
   * @return product name and quantity
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder=new StringBuilder();
    for(StockItem g: groceryList){
      stringBuilder.append(g.getProduct().getProductName()+" have "+g.getQuantity()+" ");
    }
    for(StockItem g: householdList){
      stringBuilder.append(g.getProduct().getProductName()+" have "+g.getQuantity()+" ");
    }
    return stringBuilder.toString();
  }
}
