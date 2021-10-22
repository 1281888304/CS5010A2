package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockItemTest {
  private Product product1;

  private Product product3;
  private StockItem stockItem1;
  private StockItem stockItem2;
  private StockItem stockItem3;
  private StockItem stockItem4;
  private Throwable exception;
  private StockItem stockItem;

  @BeforeEach
  void setUp() {
    product1=new Salmon("m1","salmon",2.0,1,5.0);
    product3=new PaperTowel("m2","papertowel",5.0,1,2);
    stockItem1=new StockItem(product1,2);
    stockItem2=new StockItem(product1,2);
    stockItem3=new StockItem(product3,2);
    stockItem4=new StockItem(product3,4);
  }

  @Test
  void testInput(){
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          stockItem=new StockItem(product3,-1);
        }
    );
    assertEquals("Quantity should over 0", exception.getMessage());
  }

  @Test
  void getProduct() {
    Assertions.assertEquals(product1,stockItem1.getProduct());
  }

  @Test
  void getQuantity() {
    Assertions.assertEquals(2,stockItem1.getQuantity());
  }

  @Test
  void isEnough() {
    Assertions.assertTrue(stockItem1.isEnough(1));
    Assertions.assertFalse(stockItem1.isEnough(100));
  }

  @Test
  void purchase() {
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          stockItem1.purchase(100);
        }
    );
    assertEquals("We don't have enough items", exception.getMessage());
    stockItem1.purchase(1);
    Assertions.assertEquals(1,stockItem1.getQuantity());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(stockItem1.equals(stockItem1));
    Assertions.assertTrue(stockItem1.equals(stockItem2));
    Assertions.assertFalse(stockItem3.equals(stockItem4));
    Assertions.assertFalse(stockItem3.equals(stockItem1));
    Assertions.assertFalse(stockItem3.equals(null));
    Assertions.assertFalse(stockItem3.equals(3));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(Objects.hashCode(stockItem1),stockItem1.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("StockItem{product=Salmon{Grocery{Product{Manufacturer='m1', productName='salmon', price=2.0, minimumAge=1}weight=5.0}}, quantity=2}",stockItem1.toString());
  }
}