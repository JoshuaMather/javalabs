import java.util.Arrays;
import java.io.FileWriter;
import java.io.PrintWriter;

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
      FileWriter fileWriter = new FileWriter(this.getName()+".txt");
    }

}
