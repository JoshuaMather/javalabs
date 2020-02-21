public class Plant implements Status{
  private String name;
  private boolean endangered;

  Plant(String givenName, boolean givenEndangered){
    name = givenName;
    endangered = givenEndangered;
  }

  public String getName(){
    return name;
  }

  public boolean endangered(){
      return endangered;
  }
}
