package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

  private Customer customer1;
  private Customer customer2;
  private Customer customer3;
  private Customer customer4;
  private Customer customer5;
  private Product salmon1;
  private Product beer1;
  private Product cheese1;
  private Product shampoo1;
  private Product paperTowel1, paperTowel2;
  private Name name1;
  private Name name2;
  private Inventory inventory1;
  private Salmon salmon2;
  private Shampoo shampoo2;
  private StockItem stockItem1;
  private StockItem stockItem2;
  private StockItem stockItem3;
  private StockItem stockItem4;

  @BeforeEach
  void setUp() {
    name1 = new Name("Kobe", "Kobe");
    name2 = new Name("Lebron", "Lebron");
    customer1 = new Customer(name1, 22);
    customer2 = new Customer(name1, 22);
    customer3 = new Customer(name2, 20);
    customer4 = new Customer(name1, 23);
    customer5 = new Customer(name2, 22);
    salmon1 = new Salmon("m1", "salmon1", 100.0, 1, 100.0);
    beer1 = new Beer("m1", "beer1", 2.0, 23, 5.0);
    cheese1 = new Cheese("m1", "cheese1", 1.0, 1, 1.0);
    paperTowel1 = new PaperTowel("m1", "paperTowel1", 2.0, 1, 2);
    shampoo1 = new Shampoo("m1", "shampoo1", 2.0, 1, 3);

    salmon2 = new Salmon("m1", "salmon2", 10.0, 1, 6.0);
    stockItem1 = new StockItem(salmon1, 5);
    stockItem2 = new StockItem(cheese1, 3);
    stockItem3 = new StockItem(paperTowel1, 5);

    paperTowel2 = new PaperTowel("m1", "paperTowel2", 2.0, 1, 2);
    //inventory 1 is for test findReplace that sucess find what system want same category,
    //with condition price units or weight

    inventory1 = new Inventory();
    inventory1.addStockItem(stockItem1);
    inventory1.addStockItem(stockItem2);
    inventory1.addStockItem(stockItem3);
    customer3.getShoppingCart().addProducts(beer1, 2,inventory1);
    customer3.getShoppingCart().addProduct(salmon1,inventory1);
    customer3.getShoppingCart().addProduct(cheese1,inventory1);


  }

  @Test
  void removeUnderAgeProduct() {
    Receipt receipt = new Receipt();
    receipt.addRemoveList(beer1);
    receipt.addRemoveList(beer1);
    customer3.removeUnderAgeProduct();
    Assertions.assertEquals(receipt.getRemoveList(), customer3.getReceipt().getRemoveList());
    Assertions
        .assertEquals("Shopping list:  salmon1 cheese1", customer3.getShoppingCart().toString());
  }

  @Test
  void getName() {
    Assertions.assertEquals(name1, customer1.getName());
  }

  @Test
  void getAge() {
    Assertions.assertEquals(22, customer1.getAge());
  }

  @Test
  void getShoppingCart() {
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addProducts(beer1,2,inventory1);
    shoppingCart.addProduct(salmon1,inventory1);
    shoppingCart.addProduct(cheese1,inventory1);
    Assertions.assertEquals(shoppingCart, customer3.getShoppingCart());

  }

  @Test
  void getReceipt() {
    Assertions.assertEquals(new Receipt(),customer4.getReceipt());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(customer1.equals(customer1));
    //Assertions.assertFalse(customer1.equals(customer2));
    Assertions.assertFalse(customer1.equals(null));
    Assertions.assertFalse(customer1.equals(1));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(Objects.hashCode(customer1),customer1.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Kobe Kobe age at 22 remove list:  get out of stock list:  get received list: ",customer1.toString());

  }

  @Test
  void findReplace() {
    System.out.println(inventory1.toString());

    //test if not same category

    Product replace2 = customer1.findReplace(beer1, inventory1);
    Product replace3 = customer1.findReplace(shampoo1, inventory1);

    Assertions.assertEquals(null, replace2);
    Assertions.assertEquals(null, replace3);

    //test same category
    Product replace4 = customer1.findReplace(paperTowel2, inventory1);
    Product replace5= customer1.findReplace(salmon2,inventory1);
    Assertions.assertEquals(paperTowel1,replace4);
    Assertions.assertEquals(null,replace5);
    System.out.println(inventory1.toString());
  }

  @Test
  void processOrder() {
    List<Product> list=new ArrayList<>();
    Receipt receipt=new Receipt();
    //beer is need to remove, salmon 2 is out of stock because price of salmon1 is too high
    //cheese1 is need to recived shampoo is out of stock and no replace
    // papertowel1 is received and papertowel 2 is can be replace by papertowel1
    list.add(beer1);
    list.add(salmon1);
    list.add(salmon2);
    list.add(cheese1);
    list.add(cheese1);
    list.add(shampoo1);
    list.add(paperTowel1);
    list.add(paperTowel2);
    customer3.getShoppingCart().setProductList(list);
    receipt.addRemoveList(beer1);
    receipt.addOUtOfStockList(salmon2);
    receipt.addOUtOfStockList(shampoo1);
    receipt.addOUtOfStockList(paperTowel2);
    receipt.addReceivedList(salmon1);
    receipt.addReceivedList(cheese1);
    receipt.addReceivedList(cheese1);
    receipt.addReceivedList(paperTowel1);
    receipt.addReceivedList(paperTowel1);
    Receipt receipt1=customer3.processOrder(inventory1);
    Assertions.assertEquals(receipt,receipt1);


  }
}