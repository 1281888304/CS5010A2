package assignment2.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaperTowelTest {
  private PaperTowel product1;


  @BeforeEach
  void setUp() {
    product1=new PaperTowel("m2","papertowel",5.0,1,2);
  }

  @Test
  void testToString() {
    Assertions.assertEquals("PaperTowel{Household{Product{Manufacturer='m2', productName='papertowel', price=5.0, minimumAge=1}units=2}}",product1.toString());
  }
}