package assignment2.problem1;


import java.util.ArrayList;
import java.util.List;

/**
 * receipt object contains total price and received list,out of stock list, and remove list of products
 */
public class Receipt {
  private double totalPrice;
  private List<Product> receivedList;
  private List<Product> outStockList;
  private List<Product> removeList;

  /**
   * assign default value
   */
  public Receipt() {
    totalPrice=0;
    receivedList=new ArrayList<>();
    outStockList=new ArrayList<>();
    removeList=new ArrayList<>();
  }

  /**
   * @return total price
   */
  public double getTotalPrice() {
    double sum=0;
    for(Product p:receivedList){
      sum+=p.getPrice();
    }
    return sum;
  }

  /**
   * @param product product need to add to removeList
   */
  public void addRemoveList(Product product){
    this.removeList.add(product);
  }

  /**
   * @param product add to out of stock list
   */
  public void addOUtOfStockList(Product product){
    this.outStockList.add(product);
  }

  /**
   * @param product product
   */
  public void addReceivedList(Product product){
    this.receivedList.add(product);
  }

  /**
   * @return receive list
   */
  public List<Product> getReceivedList() {
    return receivedList;
  }

  /**
   * @return out of stock list
   */
  public List<Product> getOutStockList() {
    return outStockList;
  }

  /**
   * @return remove list
   */
  public List<Product> getRemoveList() {
    return removeList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Receipt)) {
      return false;
    }

    Receipt receipt = (Receipt) o;

    if (Double.compare(receipt.getTotalPrice(), getTotalPrice()) != 0) {
      return false;
    }
    if (!getReceivedList().equals(receipt.getReceivedList())) {
      return false;
    }
    if (!getOutStockList().equals(receipt.getOutStockList())) {
      return false;
    }
    return getRemoveList().equals(receipt.getRemoveList());
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(getTotalPrice());
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (getReceivedList() != null ? getReceivedList().hashCode() : 0);
    result = 31 * result + (getOutStockList() != null ? getOutStockList().hashCode() : 0);
    result = 31 * result + (getRemoveList() != null ? getRemoveList().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder=new StringBuilder();
    stringBuilder.append("total price is ");
    stringBuilder.append(getTotalPrice());
    stringBuilder.append(" removeList( under minimum age )");
    for(Product product: this.removeList){
      stringBuilder.append(product.getProductName()).append(" ");
    }
    stringBuilder.append(" out of stock list ");
    for(Product product: this.outStockList){
      stringBuilder.append(product.getProductName()).append(" ");
    }
    stringBuilder.append(" received list ");
    for(Product p: this.receivedList){
      stringBuilder.append(p.getProductName()).append(" ");
    }
    return stringBuilder.toString();
  }
}

