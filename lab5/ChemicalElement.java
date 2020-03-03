import java.util.Arrays;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
import java.io.Serialazable;

class ChemicalElement {

    private String name;
    private String symbol;
    private int atomicNumber;

    /*
     * Symbols for elements with which this element can form a covalent bond.
     */
    private String[] bondsWith;

    public ChemicalElement(String name, String symbol, int atomicNumber, String[] bonds) {
        this.setName(name);
        this.setSymbol(symbol);
        this.setAtomicNumber(atomicNumber);
        this.setBonds(bonds);
    }

    public boolean bondsWith(String symbol) {
        return Arrays.asList(this.getBonds()).contains(symbol);
    }

    public int getAtomicNumber() {
        return this.atomicNumber;
    }

    public String[] getBonds() {
        return this.bondsWith;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void print() {
        System.out.println("=== " + this.getName() + " ===");
        System.out.println("Symbol: " + this.getSymbol());
        System.out.println("Atomic Number: " + this.getAtomicNumber());
        System.out.println("bondsWith: " + Arrays.toString(this.getBonds()));
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setBonds(String[] bonds) {
        this.bondsWith = bonds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String toJSON(){
      String jsonstr = "";
      jsonstr = jsonstr + "{    ";
      jsonstr = jsonstr + String.format("%s: %d", "\n   \"atomicNumber\"", this.getAtomicNumber());
      jsonstr = jsonstr + String.format("%s: %s", ",\n   \"bondsWith\"", Arrays.toString(this.getBonds()));
      jsonstr = jsonstr + String.format("%s: %s", ",\n   \"name\"", this.getName());
      jsonstr = jsonstr + String.format("%s: %s", ",\n   \"symbol\"", this.getSymbol());
      jsonstr = jsonstr + ",\n}";
      return jsonstr;
    }

    public String[] toJSONLines(){
      String[] jsonarr = {"","","","","",""};
      jsonarr[0] = "{";
      jsonarr[1] = "     \"atomicNumber\": " + this.getAtomicNumber() + ",";
      jsonarr[2] = "     \"bondsWith\": " + Arrays.toString(this.getBonds()) + ",";
      jsonarr[3] = "     \"name\": " + this.getName() + ",";
      jsonarr[4] = "     \"symbol\": " + this.getSymbol();
      jsonarr[5] = "}";
      return jsonarr;
    }

    public void writeJSONFromLines(){
      String[] lines = toJSONLines();
      File file = new File(this.getName()+".txt");
      try(FileWriter fileWriter = new FileWriter(file)){

        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(int i=0; i<lines.length; i++){
          printWriter.println(lines[i]);
        }

        fileWriter.close();
        printWriter.close();
      }catch(IOException e){
        System.out.println("Error");
      }

    }

    public void writeJSON(){
      String fileContent = toJSON();
      File file = new File(this.getName()+"2.txt");

      try(FileWriter fileWriter = new FileWriter(file)){
        fileWriter.write(fileContent);

        fileWriter.close();
      }catch(IOException e){
        System.out.println("Error");
      }
    }

    public ChemicalElement readJSON(String file){
      try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

        String line = bufferedReader.readLine();

        while (line != null){
          System.out.println(line);

          String name = "";
          String symbol = "";
          int atomicNumber = -1;
          String[] bonds = {};
          System.out.println(bonds);

          String[] parts = line.strip().split(":"); // needs java 11

          String clean_value = parts[1].split(",")[0].strip();

          switch (parts[0]) {
            case "\"atomicNumber\"":
              atomicNumber = Integer.parseInt(clean_value);
              break;
            case "\"bondsWith\"":
              clean_value = "[\"Cl\", \"H\"]".substring(
                      1, clean_value.length()
                  );
              bonds = clean_value.split(",");
              break;
            case "\"name\"":
              name = clean_value;
              break;
            case "\"symbol\"":
              symbol = clean_value;
              break;
          }

          line = bufferedReader.readLine();
        }


        bufferedReader.close();
        return new ChemicalElement(name, symbol, atomicNumber, bonds);

      }catch(IOException e){
        System.out.println("Error");
        return null;
      }
    }



}
