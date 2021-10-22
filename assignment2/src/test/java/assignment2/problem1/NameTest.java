package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
  private Name name1;
  private Name name2;
  private Name name3;
  private Name name4;
  private Name name5;
  private Name name6;
  private Throwable exception;

  @BeforeEach
  void setUp() {
    name1=new Name("Lebron","James");
    name2=new Name("Lebron","James");
    name3=new Name("Lebrin","James");
    name4=new Name("Lebron","Jame");
    name6=new Name("Kobe","Kobe");
  }

  @Test
  void testInput(){
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          name5=new Name("","James");
        }
    );
    assertEquals("Please enter correct first name", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          name5=new Name(null,"James");
        }
    );
    assertEquals("Please enter correct first name", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          name5=new Name("Lebron","");
        }
    );
    assertEquals("Please enter correct last name", exception.getMessage());
    exception = assertThrows(
        IllegalArgumentException.class, () -> {
          name5=new Name("Lebron",null);
        }
    );
    assertEquals("Please enter correct last name", exception.getMessage());
  }

  @Test
  void getFirstName() {
    Assertions.assertEquals("Lebron",name1.getFirstName());
  }

  @Test
  void getLastName() {
    Assertions.assertEquals("James",name1.getLastName());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(name1.equals(name2));
    Assertions.assertTrue(name1.equals(name1));
    Assertions.assertFalse(name1.equals(name3));
    Assertions.assertFalse(name1.equals(name4));
    Assertions.assertFalse(name1.equals(name6));
    Assertions.assertFalse(name1.equals(null));
    Assertions.assertFalse(name1.equals(" "));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(Objects.hashCode(name1),name1.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Lebron James",name1.toString());
  }
}