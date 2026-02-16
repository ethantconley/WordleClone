import java.util.Scanner;
/**
 * This program is an adaptation/clone of the word game Wordle.
 * This game is intended to be a fully functional wordle copy. 
 * To start, change the string in the constructor ("bones") to 
 *  Whatever 5 letter word you would like.
 * There is currently no dictionary support,
 * and incorrect handling of multiple instances of the same letter.
 * I am working on this as a learning project, so don't take it too seriously please :)
 * 
 * @author Ethan T Conley, ethantconley@gmail.com
 * @version Feb 2, 2026
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nWelcome to not wordle..... its called world....");
        // System.out.println("a is green\nb is yellow\nc is gray (like in real wordle)");
        Wordle wordle = new Wordle("bones");
        String entry = "";
        Scanner scn = new Scanner(System.in);
        while (wordle.guesses < 6){
            System.out.println();
            while (true){
                System.out.print("Guess: ");
                entry = scn.nextLine();
                if (entry.length() == 5){
                    break;
                }
                System.out.println("Invalid length for your guess.");
            }
            String results = wordle.guess(entry);
            if (wordle.word.equals(entry)){
                System.out.println("Correct word guessed: " + entry);
                for (int i = 0; i < wordle.guesses; i++){
                    System.out.println((i+1) + ". " + wordle.history[i]);
                }
                break;
            }
            for (int i = 0; i < wordle.guesses; i++){
                System.out.println((i+1) + ". " + wordle.history[i]);
            }
            System.out.println("Results: "+ results);
        }
        scn.close();

    }
}
