package assignment2.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalmonTest {
  private Salmon product1;

  @BeforeEach
  void setUp() {
    product1=new Salmon("m1","salmon",2.0,1,5.0);
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Salmon{Grocery{Product{Manufacturer='m1', productName='salmon', price=2.0, minimumAge=1}weight=5.0}}",product1.toString());

  }
}