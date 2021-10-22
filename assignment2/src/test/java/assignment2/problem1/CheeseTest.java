package assignment2.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheeseTest {
  private Cheese cheese;

  @BeforeEach
  void setUp() {
    cheese=new Cheese("m1","cheese",2.0,1,1.2);
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Cheese{Grocery{Product{Manufacturer='m1', productName='cheese', price=2.0, minimumAge=1}weight=1.2}}",cheese.toString());
  }
}