/* class SwitchTester {
  public static void main(String args[]) {
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
  }
} */
