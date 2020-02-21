class ExtendedPerson extends Person{
  private int age;
  public ExtendedPerson(String nameIn, String surnameIn, String genderIn, int ageIn){
    name=nameIn;
    surname=surnameIn;
    gender=genderIn;
    age=ageIn;
  }
  
  public int getAge(){
    return age;
  }
}
