package assignment2.problem1;

/**
 * Customer object hold name,age and shopping cart
 */
public class Customer {

  private Name name;
  private int age;
  private ShoppingCart shoppingCart;
  private Receipt receipt;

  private final int minAge = 1;
  private final int minDrinkAge = 21;

  /**
   * @param name name of customer
   * @param age  age of customer
   */
  public Customer(Name name, int age) {
    if (name == null) {
      throw new IllegalArgumentException("Please provide name");
    }
    this.name = name;
    if (age < minAge) {
      throw new IllegalArgumentException("Please provide valid age");
    }
    this.age = age;
    this.shoppingCart = new ShoppingCart();
    this.receipt = new Receipt();
  }

  /**
   * remove products not require age and delete from shopping cart also add to remove list
   */
  public void removeUnderAgeProduct() {

    for (int i = 0; i < shoppingCart.getProductList().size(); i++) {
      if (shoppingCart.getProductList().get(i).getMinimumAge() > this.age) {
        this.receipt.addRemoveList(shoppingCart.getProductList().get(i));
        this.shoppingCart.getProductList().remove(i);
        i--;
      }
    }
  }

  /**
   * full fill the order
   *
   * @param product   product need to be replace
   * @param inventory inventory system
   * @return replace product or null
   */
  public Product findReplace(Product product, Inventory inventory) {

    if (product instanceof Grocery) {

      for (StockItem stockItem : inventory.getGroceryList()) {
        if (stockItem.getProduct().getClass().equals(product.getClass())
            && stockItem.getQuantity() >= 1 &&
            stockItem.getProduct().getPrice() <= product.getPrice() &&
            ((Grocery) stockItem.getProduct()).getWeight() >= ((Grocery) product).getWeight()) {
          stockItem.purchase(1);
          return stockItem.getProduct();
        }


      }
    } else if (product instanceof Household) {
      for (StockItem stockItem : inventory.getHouseholdList()) {
        if (stockItem.getProduct().getClass().equals(product.getClass())
            && stockItem.getQuantity() >= 1 &&
            stockItem.getProduct().getPrice() <= product.getPrice() &&
            ((Household) stockItem.getProduct()).getUnits() >= ((Household) product).getUnits()) {
          stockItem.purchase(1);
          return stockItem.getProduct();
        }
      }
    }
    return null;
  }

  /**
   * try to try maximum help customer, if inventory only have 5 cheese1 and customer need 6 help
   * customer get 5 cheese1 and get one of another cheese
   *
   * @param inventory inventory
   * @return receipt
   */
  public Receipt processOrder(Inventory inventory) {
    removeUnderAgeProduct();
    //now remove all age is not correct
    for (Product item : this.shoppingCart.getProductList()) {
      if (item instanceof Grocery) {
        //stockitem in inventory
        //use boolean to check if find or not
        boolean find = false;
        for (StockItem stockItem : inventory.getGroceryList()) {
          if (stockItem.getProduct() == item) {
            find = true;
            if (stockItem.getQuantity() > 0) {
              stockItem.purchase(1);
              this.receipt.addReceivedList(item);
            } else {
              this.receipt.addOUtOfStockList(item);
              Product replace = findReplace(item, inventory);
              if (replace != null) {
                this.receipt.addReceivedList(replace);
              }

            }
            //done the search and break the for loop
//            break;
          }
        }
        if (!find) {
          this.receipt.addOUtOfStockList(item);
          Product replace = findReplace(item, inventory);
          if (replace != null) {
            this.receipt.addReceivedList(replace);
          }
        }
      } else {
        //in household list
        boolean find = false;
        for (StockItem stockItem : inventory.getHouseholdList()) {
          if (stockItem.getProduct() == item) {
            find=true;
            if (stockItem.getQuantity() > 0) {
              stockItem.purchase(1);
              this.receipt.addReceivedList(item);
            } else {
              this.receipt.addOUtOfStockList(item);
              Product replace = findReplace(item, inventory);
              if (replace != null) {
                this.receipt.addReceivedList(replace);
              }
            }
            //done the search and break the for loop
//            break;
          }
        }
        if (!find) {
          this.receipt.addOUtOfStockList(item);
          Product replace = findReplace(item, inventory);
          if (replace != null) {
            this.receipt.addReceivedList(replace);
          }
        }
      }
    }

    return this.receipt;
  }


  /**
   * @return name
   */
  public Name getName() {
    return name;
  }

  /**
   * @return age
   */
  public int getAge() {
    return age;
  }

  /**
   * @return shopping cart
   */
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  /**
   * @return receipt
   */
  public Receipt getReceipt() {
    return receipt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customer)) {
      return false;
    }

    Customer customer = (Customer) o;

    if (getAge() != customer.getAge()) {
      return false;
    }
    if (minAge != customer.minAge) {
      return false;
    }
    if (minDrinkAge != customer.minDrinkAge) {
      return false;
    }
    if (!getName().equals(customer.getName())) {
      return false;
    }
    if (!getShoppingCart().equals(customer.getShoppingCart())) {
      return false;
    }
    return getReceipt().equals(customer.getReceipt());
  }

  @Override
  public int hashCode() {
    int result = getName().hashCode();
    result = 31 * result + getAge();
    result = 31 * result + getShoppingCart().hashCode();
    result = 31 * result + getReceipt().hashCode();
    result = 31 * result + minAge;
    result = 31 * result + minDrinkAge;
    return result;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.name.toString()).append(" age at ").append(this.age)
        .append(" remove list: ");
    for (Product product : this.receipt.getRemoveList()) {
      stringBuilder.append(" ").append(product.getProductName());
    }
    stringBuilder.append(" get out of stock list: ");
    for (Product product : this.receipt.getOutStockList()) {
      stringBuilder.append(" ").append(product.getProductName());
    }
    stringBuilder.append(" get received list: ");
    for (Product product : this.receipt.getReceivedList()) {
      stringBuilder.append(" ").append(product.getProductName());
    }
    return stringBuilder.toString();
  }
}
