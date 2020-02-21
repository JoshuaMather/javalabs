public class CheckableCustomer extends Customer implements Checkable{

  public CheckableCustomer(String id, String name, double limit){
    super(id, name, limit);

  }


  public boolean check(){
    String id =this.getCustomerId();
    if(id.length() == 4){
      if(id.charAt(0) == 'i' && id.charAt(1) == 'd'){
        if(Character.isDigit(id.charAt(2)) && Character.isDigit(id.charAt(3))){
          return true;
        }

      }
    }

    return false;
  }
}
