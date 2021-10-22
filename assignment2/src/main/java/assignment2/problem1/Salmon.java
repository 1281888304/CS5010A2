package assignment2.problem1;

/**
 * salmon object
 */
public class Salmon extends Grocery{

  /**
   * @param manufacturer grocery's manufacturer
   * @param productName  grocery's product name
   * @param price        grocery's price
   * @param minimumAge   grocery's minimun age
   * @param weight       grocery's weight
   */
  public Salmon(String manufacturer, String productName, double price, int minimumAge,
      double weight) {
    super(manufacturer, productName, price, minimumAge, weight);
  }

  @Override
  public String toString() {
    return "Salmon{"+super.toString()+"}";
  }
}
