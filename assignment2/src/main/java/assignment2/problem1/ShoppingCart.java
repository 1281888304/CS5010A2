package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * Shopping cart object contains the list of all products
 */
public class ShoppingCart {

  private List<Product> productList;
  private final int minQuantity=1;

  /**
   * assign product list as a new arraylist
   */
  public ShoppingCart() {
    this.productList = new ArrayList<>();
  }

  /**
   * @return productList
   */
  public List<Product> getProductList() {
    return productList;
  }

  /**
   * @param product product
   * @param inventory inventory
   */
  public void addProduct(Product product,Inventory inventory){
    if(product instanceof Grocery){
      for(StockItem stockItem: inventory.getGroceryList()){
        if(stockItem.getProduct()==product && stockItem.getQuantity()<1){
          throw new IllegalArgumentException("Not enough");
        }
      }
    }else if(product instanceof Household)
    {
      for(StockItem stockItem: inventory.getHouseholdList()){
        if(stockItem.getProduct()==product && stockItem.getQuantity()<1){
          throw new IllegalArgumentException("Not enough");
        }
      }
    }
    this.productList.add(product);
  }

  /**
   * @param product product need to add
   * @param quantity quantity of products
   * @param inventory inventory
   */
  public void addProducts(Product product,int quantity,Inventory inventory){
    if(quantity<minQuantity){
      throw new IllegalArgumentException("Quantity should over 1");
    }
    if(product instanceof Grocery){
      for(StockItem stockItem: inventory.getGroceryList()){
        if(stockItem.getProduct()==product && stockItem.getQuantity()<quantity){
          throw new IllegalArgumentException("Not enough");
        }
      }
    }else if(product instanceof Household)
    {
      for(StockItem stockItem: inventory.getHouseholdList()){
        if(stockItem.getProduct()==product && stockItem.getQuantity()<quantity){
          throw new IllegalArgumentException("Not enough");
        }
      }
    }
    for(int i=0;i<quantity;i++){
      this.productList.add(product);
    }

  }

  /**
   * @param productList productList
   */
  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ShoppingCart)) {
      return false;
    }

    ShoppingCart that = (ShoppingCart) o;

    return getProductList().equals(that.getProductList());
  }

  @Override
  public int hashCode() {
    return getProductList().hashCode();
  }

  /**
   * @return shopping cart list
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder=new StringBuilder();
    stringBuilder.append("Shopping list: ");
    for(Product product:productList){
      stringBuilder.append(" ").append(product.getProductName());
    }
    return stringBuilder.toString();
  }
}
