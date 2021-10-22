package assignment2.problem1;

/**
 * grocery product contains extra weight
 */
public abstract class Grocery extends Product{

  private double weight;
  private final int minWeight=0;

  /**
   * @param manufacturer grocery's manufacturer
   * @param productName grocery's product name
   * @param price grocery's price
   * @param minimumAge grocery's minimun age
   * @param weight grocery's weight
   */
  public Grocery(String manufacturer, String productName, double price, int minimumAge,
      double weight) {
    super(manufacturer, productName, price, minimumAge);
    if(weight<=minWeight){
      throw new IllegalArgumentException("Please enter correct weight");
    }
    this.weight = weight;
  }

  /**
   * @return weight of grocery
   */
  public double getWeight() {
    return weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Grocery)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Grocery grocery = (Grocery) o;

    return Double.compare(grocery.getWeight(), getWeight()) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(getWeight());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Grocery{" + super.toString()+
        "weight=" + weight +
        '}';
  }
}
