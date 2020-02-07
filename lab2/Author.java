public class Author{
  private String name;
  private int yearOfBirth;

  public Author(String givenName, int givenYearOfBirth){
    name = givenName;
    yearOfBirth = givenYearOfBirth;
  }

  public String getAuthorName(){
    return name;
  }

  public void setAuthorName(String givenName){
    name = givenName;
  }

  public int getYearOfBirth(){
    return yearOfBirth;
  }

  public void setYearOfBirth(int givenYearOfBirth){
    yearOfBirth = givenYearOfBirth;
  }


}
