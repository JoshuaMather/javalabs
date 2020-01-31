class magicwordsquare{

  public static void main(String args[]){
    String[][] arrStr = new String[4][4];
    /*for (int i = 0; i < arrStr.length; i++) {
      for (int j = 0; j < arrStr[i].length; j++) {
        arrStr[i][j] = "Str" + j;
        System.out.print(arrStr[i][j] + " ");
      }
      System.out.println("");
    }*/
    arrStr[0][0] = "L";
    arrStr[0][1] = "I";
    arrStr[0][2] = "M";
    arrStr[0][3] = "B";

    arrStr[1][0] = "A";
    arrStr[1][1] = "R";
    arrStr[1][2] = "E";
    arrStr[1][3] = "A";

    arrStr[2][0] = "C";
    arrStr[2][1] = "O";
    arrStr[2][2] = "R";
    arrStr[2][3] = "K";

    arrStr[3][0] = "K";
    arrStr[3][1] = "N";
    arrStr[3][2] = "E";
    arrStr[3][3] = "E";

    for (int i = 0; i < arrStr.length; i++) {
      for (int j = 0; j < arrStr[i].length; j++) {
        System.out.print(arrStr[i][j] + " ");
      }
      System.out.println("");
    }
    printRow(arrStr, 0);
    printColumn(arrStr, 2);
  }

  public static void printRow(String[][] arrstr, int row){
    String word = "";
    for (int k = 0; k<arrstr.length; k++) {
      word += arrstr[row][k];
    }
    System.out.println(word);
  }

  public static void printColumn(String[][] arrstr, int column){
    String word = "";
    for (int k = 0; k<arrstr[column].length; k++) {
      word += arrstr[k][column];
    }
    System.out.println(word);
  }
}
