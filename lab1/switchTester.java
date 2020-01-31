import java.util.Scanner;

class SwitchTester {
/*  public static void main(String args[]) {
    int a = 5;
    int b = 8;

    for (int i=1; i<6; i++) {
      b = i*i;
      switchExperiment(i, b);
  }

    System.out.println(((Object)a).getClass().getName());
    System.out.println(((Object)b).getClass().getName());
  }

  public static void switchExperiment(int a, int b) {
    switch(a) {
      case 1:
        b -= 4;
        break;
      case 2:
        b += 4;
        break;
      case 3:
        b /= 4;
        break;
      case 4:
        b *=4;
        break;
      default:
        b = 0;
        break;
    }
    System.out.println("b is " + b);
  }*/

  public static void main(String args[]) {
    Scanner monthinput = new Scanner(System.in);
    System.out.println("Enter Month");

    String month = monthinput.nextLine();
    System.out.println("Month is " + month);

    List<String> winter = new ArrayList<String>();
    winter.add("December");
    winter.add("January");
    winter.add("February");

    seasonSwitch(month);
  }

  public static void seasonSwitch(String month) {





  }


}
