package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeerTest {
  private Beer beer;
  private Beer product;
  private Throwable exception;

  @BeforeEach
  void setUp(){
    beer=new Beer("m1","beer1",1.0,22,2.2);
  }

  @Test
  void testInput(){
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          product=new Beer("null","salmon2",2.0,1,5.0);
        }
    );
    assertEquals("beer require 21 or over", exception.getMessage());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Beer{Grocery{Product{Manufacturer='m1', productName='beer1', price=1.0, minimumAge=21}weight=2.2}}",beer.toString());
  }
}