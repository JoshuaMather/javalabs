import java.io.Console;

public class HangmanDriver{

  public static void main(String[] args){
    Console console = System.console();
    Hangman hangman = new Hangman();
    HangmanDictionary dictionary = new HangmanDictionary();

    String in;
    in = console.readLine("Enter your name: ");

    hangman.setPlayerName(in);
    System.out.println("Name: " + hangman.getPlayerName());


    hangman.setWord(dictionary.getWord());

    String guess;
    char guessChar;
    do{
      guess = console.readLine("Enter a letter to guess: ");
      guessChar = guess.charAt(0);
      hangman.tryChar(guessChar);
      System.out.println(hangman.getCurrentState());
      System.out.println(hangman.getRemainingGuesses());
      System.out.println("");


    }while (hangman.getRemainingGuesses()>0 || hangman.getCurrentState() != hangman.getWord());

    String word = hangman.getCurrentState();
    System.out.println(word);





  }
}
