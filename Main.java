import java.util.Scanner;

import javax.swing.JOptionPane;
class Main {
  public static void main(String[] args) {
    String moviePicked = "The only Way";
    int x = moviePicked.length();
    char[] guess = new char[x];
    for(int a = 0; a < x; a++){
      guess[a] = '_';//since guess is a string it must equal double quotes " "
      if(moviePicked.charAt(a) == ' ') guess[a] = ' ';//the check must go after because if it was above then guess[3] wouldve again been a _
    }
    Scanner sc = new Scanner(System.in);
    boolean charFound = true; //in java its boolean
   JOptionPane.showMessageDialog(null,"This is hangman, I have picked a movie at random, you have 10 attempts good luck");
     String underscores = "";
   for(int i = 0; i < guess.length; i++){
       underscores = underscores+ guess[i] + " ";
     }
    Game.hangMan( moviePicked,guess,charFound);
  }
}
class Game{
  private static int y = 10;
  public static void hangMan( String moviePicked,char[] guess, boolean charFound){
      while(y>0){
        boolean guessEqualsMovie = true;//act like guess already equals movie 
        String input = JOptionPane.showInputDialog(null, "You have " + y + " chances left good luck!");
        char x = input.charAt(0);//x is = to the first character of input line
        charFound = false;//character hasnt been found 
            for(int i = 0; i < guess.length; i++){/*this loop compares character x with each individual character in the moviePicked string and if it is equal it sets guess[i] to equal that character index of string moviePicked to make sure that the guess array looks exactly like the moviePicked string regarding to Case Sensitivity. This loop was needed since there are often similar letters in a movie and this loop checks if the character x is repeated. */
              if(Character.toLowerCase(x) ==Character.toLowerCase(moviePicked.charAt(i))){
                  charFound = true;//set it equal to true 
                  guess[i] = moviePicked.charAt(i);//
              }
        	  }
            String guessArray = "";//this is how you add a character array to a string 
            for(int i = 0; i < guess.length; i++){
            	guessArray += guess[i] + " ";
        	    }
          JOptionPane.showMessageDialog(null, guessArray);//prints guess character array each loop
        if (charFound == false) y--;//if you didnt find a character you lose a turn and it would stay false since it never went inside the if statement in the for loop above
            for(int i = 0; i < guess.length; i++){
              if(guess[i] != moviePicked.charAt(i)) guessEqualsMovie = false;
            }
          
          if(guessEqualsMovie == true){
            System.out.println("You win! ");
            break;          }
          if(y==0){
            JOptionPane.showMessageDialog(null, "You lose, the movie was: " + moviePicked);
          }
      }
      
  }
}