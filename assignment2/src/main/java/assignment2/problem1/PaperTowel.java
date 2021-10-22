package assignment2.problem1;

/**
 * paper towel object
 */
public class PaperTowel extends Household{

  /**
   * @param manufacturer household's manufacturer
   * @param productName  household's  productname
   * @param price        household's price
   * @param minimumAge   household's minimumage
   * @param units        household's units
   */
  public PaperTowel(String manufacturer, String productName, double price, int minimumAge,
      int units) {
    super(manufacturer, productName, price, minimumAge, units);
  }

  @Override
  public String toString() {
    return "PaperTowel{"+super.toString()+"}";
  }
}
