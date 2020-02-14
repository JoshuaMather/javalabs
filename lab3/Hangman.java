public class Hangman{
  private String playerName;
  private String wordToGuess;
  public int MAX_GUESSES = 20;
  private char[] guesses = new char[MAX_GUESSES];


  public Hangman(){}

  public String getPlayerName(){
    return playerName;
  }

  public void setPlayerName(String newName){
    playerName = newName;
  }

  public String getWord(){
    return wordToGuess;
  }

  public void setWord(String newWord){
    wordToGuess = newWord;
  }

  public String getCurrentState(){
    String state = "";
    char currentChar;
    boolean match;

    for(int i=0; i<wordToGuess.length(); i++){
      currentChar = wordToGuess.charAt(i);
      match = false;

      for(int j=0; j<guesses.length; j++){
        if(guesses[j]==currentChar){
          match = true;
          //break;
        }
      }
      if(match==true){
        state = state + currentChar;
      }
      else{
        state = state + "-";
      }
    }
    return state;
  }

  public char[] getGuesses(){
    return guesses;
  }

  public int getRemainingGuesses(){
    int i = 0;
    for(int j=0; j<guesses.length; j++) {
      if(guesses[j] != '\u0000'){
        i=i+1;
      }
    }
    return (20-i);
  }

  public boolean tryChar(char givenChar){
    boolean notContain = false;
    for(int i=0; i<guesses.length; i++){
      if(guesses[i] == givenChar){
        System.out.println("Letter already guessed");
        break;
      }
      if(guesses[i] == '\u0000'){
        guesses[i] = givenChar;
        System.out.println("Letter guessed");
        notContain = true;
        break;
      }

    }
    return notContain;

  }


}
