package assignment2.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShampooTest {
  private Household product1;

  @BeforeEach
  void setUp() {
    product1=new Shampoo("m1","shampoo",2.0,1,5);
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Shampoo{Household{Product{Manufacturer='m1', productName='shampoo', price=2.0, minimumAge=1}units=5}}",product1.toString());

  }
}