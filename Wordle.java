/**
 * This class will create an instance of the game wordle
 * yes
 **/

public class Wordle {
    public String word;
    public int guesses;
    public String[] history = new String[6];

    public Wordle(String word) {
        if (word.length() > 5) {
            System.out.println(
                    "The length of word " + word + " is too long. The word used will be: " + word.substring(5));
            word = word.substring(5);
        } else if (word.length() < 5) {
            String oldWord = word;
            while (word.length() < 5) {
                word = word.concat("x");
            }
            System.out.println("The length of word " + oldWord + " is too short. The word used will be: " + word);
        } else {
            this.word = word;
        }
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m"; // Standard Yellow
    public static final String ANSI_GREEN = "\u001B[32m";
    public String guess(String gs) {

        String returner = "";
        if (gs.length() != 5) {
            return "";
        }
        
        for (int i = 0; i < 5; i++) {
            // CASE 1: LETTER LOCATION MATCHES EXACTLY
            if (gs.charAt(i) == word.charAt(i)) {
                returner = returner.concat(ANSI_GREEN + gs.charAt(i) + ANSI_RESET);
            // CASE 2: LETTER EXISTS IN WORD AT NOT THE LOCATION
            } else if (gs.charAt(i) != word.charAt(i) && word.indexOf(gs.charAt(i)) >= 0) {
                    returner = returner.concat(ANSI_YELLOW + gs.charAt(i) + ANSI_RESET);
            // CASE 3: LETTER DOES NOT EXIST IN WORD
            } else if (word.indexOf(gs.charAt(i)) == -1) {
                returner = returner.concat("" + gs.charAt(i)+ "");
            }
        }
        //check for duplicates chars:
        

        history[guesses] = returner;
        guesses++;

        return returner;
    }

}
