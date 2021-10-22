package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptTest {

  private Receipt receipt1;
  private Receipt receipt2;
  private Receipt receipt3;
  private Receipt receipt4;
  private Receipt receipt5;
  private Receipt receipt6;
  private Product product1;
  private Product product2;
  private Product product3;
  private Product product4;
  private Product product5;
  private Product product6;
  private Product product7;
  private Product product8;

  @BeforeEach
  void setUp() {
    product1 = new Salmon("m1", "salmon", 2.0, 1, 5.0);
    product2 = new Salmon("m1", "salmon2", 2.0, 1, 5.0);
    product3 = new PaperTowel("m2", "papertowel", 5.0, 1, 2);
    product4 = new Cheese("m1", "cheese", 2.0, 1, 5.0);
    product5 = new Beer("m1", "beer", 2.0, 22, 5.0);
    product6 = new Shampoo("m2", "shampoo", 5.0, 1, 2);
    product7 = new Cheese("m1", "cheese2", 2.0, 1, 5.0);
    product8 = new Cheese("m1", "cheese444", 2.0, 1, 5.0);
    receipt1 = new Receipt();
    receipt2 = new Receipt();
    receipt3 = new Receipt();
    receipt4 = new Receipt();
    receipt5 = new Receipt();
    receipt6 = new Receipt();



  }

  @Test
  void getTotalPrice() {
    receipt1.addReceivedList(product1);
    receipt1.addReceivedList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(4.0, receipt1.getTotalPrice());

  }

  @Test
  void addRemoveList() {
    receipt1.addRemoveList(product1);
    receipt1.addRemoveList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(list, receipt1.getRemoveList());

  }

  @Test
  void addOUtOfStockList() {
    receipt1.addOUtOfStockList(product1);
    receipt1.addOUtOfStockList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(list, receipt1.getOutStockList());
  }

  @Test
  void addReceivedList() {
    receipt1.addReceivedList(product1);
    receipt1.addReceivedList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(list, receipt1.getReceivedList());
  }

  @Test
  void getReceivedList() {
    receipt1.addReceivedList(product1);
    receipt1.addReceivedList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(list, receipt1.getReceivedList());
  }

  @Test
  void getOutStockList() {
    receipt1.addOUtOfStockList(product1);
    receipt1.addOUtOfStockList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(list, receipt1.getOutStockList());
  }

  @Test
  void getRemoveList() {
    receipt1.addRemoveList(product1);
    receipt1.addRemoveList(product2);
    List<Product> list = new ArrayList<>();
    list.add(product1);
    list.add(product2);
    Assertions.assertEquals(list, receipt1.getRemoveList());
  }

  @Test
  void testEquals() {
    receipt1.addOUtOfStockList(product1);
    receipt1.addReceivedList(product2);
    receipt1.addRemoveList(product3);
    receipt2.addOUtOfStockList(product1);
    receipt2.addReceivedList(product2);
    receipt2.addRemoveList(product3);
    receipt3.addOUtOfStockList(product2);
    receipt3.addReceivedList(product3);
    receipt3.addRemoveList(product1);
    receipt4.addOUtOfStockList(product1);
    receipt6.addOUtOfStockList(product7);
    receipt4.addReceivedList(product2);
    receipt4.addRemoveList(product3);
    receipt4.addOUtOfStockList(product1);
    receipt4.addReceivedList(product5);
    receipt4.addRemoveList(product5);
    receipt5.addOUtOfStockList(product1);
    receipt5.addReceivedList(product2);
    receipt5.addRemoveList(product2);
    receipt5.addRemoveList(product1);
    receipt6.addOUtOfStockList(product1);
    receipt6.addReceivedList(product2);
    receipt6.addReceivedList(product5);
    receipt6.addRemoveList(product3);
    Assertions.assertTrue(receipt1.equals(receipt1));
    Assertions.assertTrue(receipt1.equals(receipt2));
    Assertions.assertFalse(receipt1.equals(receipt3));
    Assertions.assertFalse(receipt1.equals(receipt4));
    Assertions.assertFalse(receipt1.equals(receipt5));
    Assertions.assertFalse(receipt1.equals(receipt6));
    Assertions.assertFalse(receipt1.equals(null));
    Assertions.assertFalse(receipt1.equals(" "));
  }

  @Test
  void testHashCode() {
    receipt1.addOUtOfStockList(product1);
    receipt1.addReceivedList(product2);
    receipt1.addRemoveList(product3);

    Assertions.assertEquals(Objects.hashCode(receipt1),receipt1.hashCode());
  }

  @Test
  void testToString() {
    receipt1.addOUtOfStockList(product1);
    receipt1.addReceivedList(product2);
    receipt1.addRemoveList(product3);
    Assertions.assertEquals("total price is 2.0 removeList( under minimum age )papertowel  out of stock list salmon  received list salmon2 ",receipt1.toString());
  }
}