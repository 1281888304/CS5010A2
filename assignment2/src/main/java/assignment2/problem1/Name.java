package assignment2.problem1;

/**
 * name class contains first name and last name
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * @param firstName first name
   * @param lastName last name
   */
  public Name(String firstName, String lastName) {
    if(firstName==null || firstName.length()<1){
      throw new IllegalArgumentException("Please enter correct first name");
    }
    this.firstName = firstName;
    if(lastName==null || lastName.length()<1){
      throw new IllegalArgumentException("Please enter correct last name");
    }
    this.lastName = lastName;
  }

  /**
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Name)) {
      return false;
    }

    Name name = (Name) o;

    if (!getFirstName().equals(name.getFirstName())) {
      return false;
    }
    return getLastName().equals(name.getLastName());
  }

  @Override
  public int hashCode() {
    int result = getFirstName().hashCode();
    result = 31 * result + getLastName().hashCode();
    return result;
  }

  /**
   * @return first name and last name
   */
  @Override
  public String toString() {
    return this.firstName+" "+this.lastName;
  }
}
