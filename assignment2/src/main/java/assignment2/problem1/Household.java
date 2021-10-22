package assignment2.problem1;

/**
 * household object contains extra units
 */
public abstract class Household extends Product{

  private int units;
  private final int minUnit=0;

  /**
   * @param manufacturer household's manufacturer
   * @param productName household's  productname
   * @param price household's price
   * @param minimumAge household's minimumage
   * @param units household's units
   */
  public Household(String manufacturer, String productName, double price, int minimumAge,
      int units) {
    super(manufacturer, productName, price, minimumAge);
    if(units<minUnit){
      throw new IllegalArgumentException("please enter correct units");
    }
    this.units = units;
  }

  /**
   * @return household's units
   */
  public int getUnits() {
    return units;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Household)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Household household = (Household) o;

    if (getUnits() != household.getUnits()) {
      return false;
    }
    return minUnit == household.minUnit;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + getUnits();
    result = 31 * result + minUnit;
    return result;
  }

  @Override
  public String toString() {
    return "Household{" +super.toString()+
        "units=" + units +

        '}';
  }
}
