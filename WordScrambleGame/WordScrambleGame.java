package WordScrambleGame;
import java.util.*;

public class WordScrambleGame {
    // List of words
    private static final String[] WORD_LIST = {
        "python", "developer", "programming", "algorithm", "function", 
        "variable", "debugging", "compiler", "codechef", "machine", 
        "bitcoin", "operation"
    };

    public static String scrambleWord(String word) {
        /** Scramble the letters of a word randomly */
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder scrambled = new StringBuilder();
        for (char c : characters) {
            scrambled.append(c);
        }
        return scrambled.toString();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        while (true) {  
            String originalWord = WORD_LIST[random.nextInt(WORD_LIST.length)];
            String scrambled = scrambleWord(originalWord);
            
            System.out.println("\nWelcome to the Word Scramble Game!");
            System.out.println("Scrambled word: " + scrambled);

            int attempts = 3;

            while (attempts > 0) {
                System.out.print("Guess the word (or type 'exit' to quit): ");
                String guess = scanner.nextLine().toLowerCase();

                if (guess.equals("exit")) {
                    System.out.println("Thanks for playing! Goodbye!");
                    return;  
                }

                if (guess.equals(originalWord)) {
                    System.out.println("Correct! You guessed it!\n");
                    break;  
                } else {
                    attempts--;
                    System.out.println("Wrong guess. Attempts left: " + attempts);
                }
            }

            System.out.println("The correct word was: " + originalWord + "\n");

            // Ask the player if they want to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String play = scanner.nextLine().toLowerCase();
            if(play.equals("no")){
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
            scanner.close();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
