package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
  private ShoppingCart shoppingCart1;
  private ShoppingCart shoppingCart2;
  private ShoppingCart shoppingCart3;
  private ShoppingCart shoppingCart4;
  private Product product1;
  private Product product2;
  private Product product3;
  private Throwable exception;
  private Inventory inventory;
  private StockItem stockItem1;
  private StockItem stockItem2;
  private StockItem stockItem3;

  @BeforeEach
  void setUp(){
    inventory=new Inventory();

    shoppingCart1=new ShoppingCart();
    shoppingCart2=new ShoppingCart();
    shoppingCart3=new ShoppingCart();
    shoppingCart4=new ShoppingCart();
    product1=new Salmon("m1","salmon",2.0,1,5.0);
    stockItem1=new StockItem(product1,100);
    product2=new Salmon("m1","salmon",2.0,1,5.0);
    stockItem2=new StockItem(product2,100);
    product3=new PaperTowel("m2","papertowel",5.0,1,2);
    stockItem3=new StockItem(product3,100);
    inventory.addStockItem(stockItem1);
    inventory.addStockItem(stockItem2);
    inventory.addStockItem(stockItem3);
  }

  @Test
  void getProductList() {

    List<Product> list=new ArrayList<>();
    list.add(product1);
    shoppingCart1.addProduct(product1,inventory);
    Assertions.assertEquals(list,shoppingCart1.getProductList());
  }

  @Test
  void addProduct() {
    List<Product> list=new ArrayList<>();
    list.add(product1);
    list.add(product2);
    shoppingCart1.addProduct(product1,inventory);
    shoppingCart1.addProduct(product2,inventory);
    Assertions.assertEquals(list,shoppingCart1.getProductList());
  }

  @Test
  void addProducts() {
    List<Product> list=new ArrayList<>();
    list.add(product1);
    list.add(product1);
    list.add(product2);
    list.add(product2);
    shoppingCart1.addProducts(product1,2,inventory);
    shoppingCart1.addProducts(product2,2,inventory);
    Assertions.assertEquals(list,shoppingCart1.getProductList());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          shoppingCart2.addProducts(product2,-1,inventory);
        }
    );
    assertEquals("Quantity should over 1", exception.getMessage());
  }

  @Test
  void testEquals() {
    shoppingCart1.addProducts(product1,2,inventory);
    shoppingCart2.addProducts(product1,2,inventory);
    shoppingCart3.addProducts(product3,5,inventory);
    Assertions.assertTrue(shoppingCart1.equals(shoppingCart1));
    Assertions.assertTrue(shoppingCart1.equals(shoppingCart2));
    Assertions.assertFalse(shoppingCart1.equals(shoppingCart3));
    Assertions.assertFalse(shoppingCart1.equals(shoppingCart4));
    Assertions.assertFalse(shoppingCart1.equals(" "));
    Assertions.assertFalse(shoppingCart1.equals(null));

  }

  @Test
  void testHashCode() {
    shoppingCart1.addProducts(product1,2,inventory);
    shoppingCart1.addProducts(product2,2,inventory);
    Assertions.assertEquals(Objects.hashCode(shoppingCart1),shoppingCart1.hashCode());
  }

  @Test
  void testToString() {
    shoppingCart1.addProducts(product1,2,inventory);
    shoppingCart1.addProducts(product3,3,inventory);
    Assertions.assertEquals("Shopping list:  salmon salmon papertowel papertowel papertowel",shoppingCart1.toString());
  }

  @Test
  void setProductList() {
    List<Product> list=new ArrayList<>();
    list.add(product2);
    list.add(product1);
    list.add(product1);
    shoppingCart1.setProductList(list);
    Assertions.assertEquals(list,shoppingCart1.getProductList());
  }
}