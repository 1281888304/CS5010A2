package assignment2.problem1;

/**
 * StockItem object contains product and quantity
 */
public class StockItem {

  private Product product;
  private int quantity;
  private final int minQuantity=0;

  /**
   * @param product product in stockitem
   * @param quantity quantity
   */
  public StockItem(Product product, int quantity) {
    this.product = product;
    if(quantity<minQuantity){
      throw new IllegalArgumentException("Quantity should over 0");
    }
    this.quantity = quantity;
  }

  /**
   * @return product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * @return quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity quantity
   * @return true if enough purchase
   */
  public boolean isEnough(int quantity){
    return this.quantity>=quantity;
  }

  /**
   * @param quantity quantity of shopping cart
   */
  public void purchase(int quantity){
    if(!isEnough(quantity)){
      throw new IllegalArgumentException("We don't have enough items");
    }
    this.quantity-=quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StockItem)) {
      return false;
    }

    StockItem stockItem = (StockItem) o;

    if (getQuantity() != stockItem.getQuantity()) {
      return false;
    }
    return getProduct().equals(stockItem.getProduct());
  }

  @Override
  public int hashCode() {
    int result = getProduct().hashCode();
    result = 31 * result + getQuantity();
    return result;
  }

  @Override
  public String toString() {
    return "StockItem{" +
        "product=" + product +
        ", quantity=" + quantity +
        '}';
  }
}
