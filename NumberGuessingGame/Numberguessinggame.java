import java.util.*;
public class Numberguessinggame {
    // Method to generate a random number between 1 and 100
    public static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }
    public static String giveHint(int number, int guess) {
        if (guess > (number + 10) || guess < (number - 10)) {
            return "Cold";
        } else if (number == guess) {
            return "Right";
        } else {
            return "Hot";
        }
    }
    public static void runGuess() {
        int secretNumber = getRandomNumber();
        int userGuess;
        String hint;
        Scanner scanner = new Scanner(System.in);
        while (true) { // Keep asking until correct
            System.out.print("Enter a number between 1 and 100: ");
            userGuess = scanner.nextInt();
            hint = giveHint(secretNumber, userGuess);

            if (hint.equals("Right")) {
                System.out.println("You guessed it Right!");
                break; // Exit loop when guessed correctly
            } else {
                System.out.println(hint);
            }
        }
        scanner.close();
    }
    public static void main(String[] args) {
        runGuess();
    }
}
