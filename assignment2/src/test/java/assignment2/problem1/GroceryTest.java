package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroceryTest {
  private Grocery product1;
  private Grocery product2;
  private Grocery product3;
  private Grocery product;
  private Throwable exception;

  @BeforeEach
  void setUp() {
    product1=new Salmon("m1","salmon",2.0,1,5.0);
    product2=new Salmon("m1","salmon",2.0,1,5.0);
    product3=new Cheese("m2","papertowel",5.0,1,2.0);
  }

  @Test
  void testInput(){
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon(null,"salmon2",2.0,1,5.0);
        }
    );
    assertEquals("Please enter correct manufacturer", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon("null","",2.0,1,5.0);
        }
    );
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon("","salmon2",2.0,1,5.0);
        }
    );
    assertEquals("Please enter correct manufacturer", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon("null",null,2.0,1,5.0);
        }
    );
    assertEquals("Please enter correct product name", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon("null","name",2.0,0,5.0);
        }
    );
    assertEquals("Please enter correct age", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon("null","name",-1,0,5.0);
        }
    );
    assertEquals("Please enter a correct price", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Salmon("null","name",1,10,-1.0);
        }
    );
    assertEquals("Please enter correct weight", exception.getMessage());
  }

  @Test
  void getWeight() {
    Assertions.assertEquals(5.0,product1.getWeight());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(product1.equals(product1));
    Assertions.assertTrue(product1.equals(product2));
    Assertions.assertFalse(product1.equals(product3));
    Assertions.assertFalse(product1.equals(product));
    Assertions.assertFalse(product1.equals(null));
    Assertions.assertFalse(product1.equals(" "));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(Objects.hashCode(product1),product1.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Salmon{Grocery{Product{Manufacturer='m1', productName='salmon', price=2.0, minimumAge=1}weight=5.0}}", product1.toString());
  }
}