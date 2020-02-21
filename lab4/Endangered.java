public class Endangered{
  public static void main(String args[]){
    Object [] objects = {new Oak(),new Baobab()};
    for (int i=0; i < objects.length; i++){
      System.out.println(((Plant)objects[i]).getName()+
      " is endangered: "+((Plant)objects[i]).endangered());
    }
  }
}
