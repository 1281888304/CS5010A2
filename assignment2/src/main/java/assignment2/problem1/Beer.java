package assignment2.problem1;

/**
 * Beer object class
 */
public class Beer extends Grocery{

  private final int beerAge=21;

  /**
   * @param manufacturer grocery's manufacturer
   * @param productName  grocery's product name
   * @param price        grocery's price
   * @param minimumAge   grocery's minimun age
   * @param weight       grocery's weight
   */
  public Beer(String manufacturer, String productName, double price, int minimumAge,
      double weight) {

    super(manufacturer, productName, price, 21, weight);
    if(minimumAge<beerAge){
      throw new IllegalArgumentException("beer require 21 or over");
    }

  }


  @Override
  public String toString() {
    return "Beer{" +super.toString()
        +
        '}';
  }
}
