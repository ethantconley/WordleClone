import java.util.Scanner;
/**
 * TODO Write a one-sentence summary of your  here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author  TODO Put Your Name in the author tag
 * @version Dec 14, 2025
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
