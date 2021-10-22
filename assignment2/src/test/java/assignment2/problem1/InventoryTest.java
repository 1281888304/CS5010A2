package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {
  private Grocery salmon;
  private Grocery cheese;
  private Grocery beer;
  private Household paperTowel;
  private Household shampoo;
  private StockItem stockItem1;
  private StockItem stockItem2;
  private StockItem stockItem3;
  private StockItem stockItem4;
  private StockItem stockItem5;
  private Inventory inventory1;
  private Inventory inventory2;
  private Inventory inventory3;
  private Inventory inventory4;
  private Inventory inventory5;

  @BeforeEach
  void setUp() {
    beer=new Beer("m1","beer1",1.0,22,2.2);
    cheese=new Cheese("m1","cheese",2.0,1,1.2);
    salmon=new Salmon("m1","salmon",2.0,1,5.0);
    paperTowel=new PaperTowel("m2","papertowel",5.0,1,2);
    shampoo=new Shampoo("m1","shampoo",2.0,1,5);
    stockItem1=new StockItem(beer,4);
    stockItem2=new StockItem(cheese,5);
    stockItem3=new StockItem(salmon,5);
    stockItem4=new StockItem(paperTowel,6);
    stockItem5=new StockItem(shampoo,7);
    inventory1=new Inventory();
    inventory2=new Inventory();
    inventory3=new Inventory();
    inventory4=new Inventory();
    inventory5=new Inventory();


  }

  @Test
  void getGroceryList() {

    inventory1.addStockItem(stockItem1);
    inventory1.addStockItem(stockItem2);
    List<StockItem> list1=new ArrayList<>();
    list1.add(stockItem1);
    list1.add(stockItem2);
    Assertions.assertEquals(list1,inventory1.getGroceryList());
  }

  @Test
  void getHouseholdList() {
    inventory1.addStockItem(stockItem4);
    inventory1.addStockItem(stockItem5);

    //list test household list
    List<StockItem> list2=new ArrayList<>();
    list2.add(stockItem4);
    list2.add(stockItem5);
    Assertions.assertEquals(list2,inventory1.getHouseholdList());
  }

  @Test
  void addStockItem() {
    inventory1.addStockItem(stockItem1);
    inventory1.addStockItem(stockItem2);
    //list test grocery
    List<StockItem> list1=new ArrayList<>();
    list1.add(stockItem1);
    list1.add(stockItem2);
    Assertions.assertEquals(list1,inventory1.getGroceryList());
    inventory1.addStockItem(stockItem4);
    inventory1.addStockItem(stockItem5);
    inventory1.addStockItem(stockItem3);
    //list test household list
    List<StockItem> list2=new ArrayList<>();
    list2.add(stockItem4);
    list2.add(stockItem5);
    Assertions.assertEquals(list2,inventory1.getHouseholdList());
  }

  @Test
  void retailValue() {
    inventory1.addStockItem(stockItem4);
    inventory1.addStockItem(stockItem5);
    inventory1.addStockItem(stockItem3);
    //list test household list

    Assertions.assertEquals(9,inventory1.retailValue());
  }

  @Test
  void testEquals() {
    inventory1.addStockItem(stockItem2);
    inventory1.addStockItem(stockItem5);
    inventory2.addStockItem(stockItem2);
    inventory2.addStockItem(stockItem5);
    inventory3.addStockItem(stockItem1);
    inventory3.addStockItem(stockItem4);
    inventory4.addStockItem(stockItem2);
    inventory4.addStockItem(stockItem4);
    inventory5.addStockItem(stockItem1);
    inventory5.addStockItem(stockItem5);
    Assertions.assertTrue(inventory1.equals(inventory1));
    Assertions.assertTrue(inventory1.equals(inventory2));
    Assertions.assertFalse(inventory1.equals(inventory3));
    Assertions.assertFalse(inventory1.equals(inventory4));
    Assertions.assertFalse(inventory1.equals(inventory5));
    Assertions.assertFalse(inventory1.equals(null));
    Assertions.assertFalse(inventory1.equals(" "));

  }

  @Test
  void testHashCode() {
    inventory1.addStockItem(stockItem4);
    inventory1.addStockItem(stockItem1);
    Assertions.assertEquals(Objects.hashCode(inventory1),inventory1.hashCode());

  }

  @Test
  void testToString() {
    inventory1.addStockItem(stockItem1);
    inventory1.addStockItem(stockItem2);
    inventory1.addStockItem(stockItem5);
    Assertions.assertEquals("beer1 have 4 cheese have 5 shampoo have 7 ",inventory1.toString());
  }
}