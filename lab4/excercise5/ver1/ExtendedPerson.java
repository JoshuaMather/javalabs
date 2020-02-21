class ExtendedPerson extends Person{
  private int age;
  public ExtendedPerson(String nameIn, String surnameIn, String genderIn, int ageIn){
    super(nameIn,surnameIn, genderIn );

    age=ageIn;
  }

  public int getAge(){
    return age;
  }
}
