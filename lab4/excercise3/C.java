interface I{
  public void m1();
}



class C implements I{
  public void m1(){
    System.out.println("This is m1");
  }
  public static void main(String args[]){
    C c = new C();
    c.m1();
  }
}
