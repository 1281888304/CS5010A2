package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseholdTest {
  private Household product1;
  private Household product2;
  private Household product3;
  private Household product;
  private Throwable exception;

  private Household household5;

  @BeforeEach
  void setUp() {
    product1=new Shampoo("m1","shampoo",2.0,1,5);
    product2=new Shampoo("m1","shampoo",2.0,1,5);
    household5=new Shampoo("m1","shampoo",2.0,1,6);
    product3=new PaperTowel("m2","papertowel",5.0,1,2);
  }

  @Test
  void testInput(){
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Shampoo("m2","name",1,10,-5);
        }
    );
    assertEquals("please enter correct units", exception.getMessage());
  }

  @Test
  void getUnits() {
    Assertions.assertEquals(5,product1.getUnits());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(product1.equals(product1));
    Assertions.assertTrue(product1.equals(product2));
    Assertions.assertFalse(product1.equals(product3));
    Assertions.assertFalse(product1.equals(product));
    Assertions.assertFalse(product1.equals(null));
    Assertions.assertFalse(product1.equals(" "));
    Assertions.assertFalse(product1.equals(household5));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(Objects.hashCode(product1),product1.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Shampoo{Household{Product{Manufacturer='m1', productName='shampoo', price=2.0, minimumAge=1}units=5}}",product1.toString());
  }
}