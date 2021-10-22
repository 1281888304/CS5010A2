package assignment2.problem1;

/**
 * product abstract class include manufacturer, name,price , minimum age
 */
public abstract class Product {

  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;
  private final int minAge=0;
  private final int minPrice=0;

  /**
   * @param manufacturer manufacturer of product
   * @param productName product name of product
   * @param price product's price
   * @param minimumAge product's minimumage
   */
  public Product(String manufacturer, String productName, double price, int minimumAge) {
    if(manufacturer==null || manufacturer.length()<1){
      throw new IllegalArgumentException("Please enter correct manufacturer");
    }
    this.manufacturer = manufacturer;
    if(productName==null || productName.length()<1){
      throw new IllegalArgumentException("Please enter correct product name");
    }
    this.productName = productName;
    if(price<minPrice){
      throw new IllegalArgumentException("Please enter a correct price");
    }
    this.price = price;
    if(minimumAge<=minAge){
      throw new IllegalArgumentException("Please enter correct age");
    }
    this.minimumAge = minimumAge;
  }

  /**
   * @return manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }


  /**
   * @return product name
   */
  public String getProductName() {
    return productName;
  }


  /**
   * @return price
   */
  public double getPrice() {
    return price;
  }


  /**
   * @return minimum age
   */
  public int getMinimumAge() {
    return minimumAge;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }

    Product product = (Product) o;

    if (Double.compare(product.getPrice(), getPrice()) != 0) {
      return false;
    }
    if (getMinimumAge() != product.getMinimumAge()) {
      return false;
    }
    if (!getManufacturer().equals(product.getManufacturer())) {
      return false;
    }
    return getProductName().equals(product.getProductName());
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = getManufacturer().hashCode();
    result = 31 * result + getProductName().hashCode();
    temp = Double.doubleToLongBits(getPrice());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + getMinimumAge();
    return result;
  }

  @Override
  public String toString() {
    return "Product{" +
        "Manufacturer='" + manufacturer + '\'' +
        ", productName='" + productName + '\'' +
        ", price=" + price +
        ", minimumAge=" + minimumAge +
        '}';
  }
}
