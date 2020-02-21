class Person{
  protected String name;
  protected String surname;
  protected String gender;

  public Person(String nameIn, String surnameIn, String genderIn){
    name=nameIn;
    surname=surnameIn;
    gender=genderIn;
  }
  public String getName(){
    return name;
  }

  public String getSurname(){
    return surname;
  }
  public String getGender(){
    return gender;
  }
}
