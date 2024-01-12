import java.util.Random;
import java.util.Scanner;

public class GSN {
    public static void main(String[] args) {

        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 10;

        Random random = new Random();
        int randomNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;

        int userGuess;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number!");
        System.out.println("Try to guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");

        while (playAgain) {
            attempts = 0;
            int remainingAttempts = MAX_ATTEMPTS;

            do {
                System.out.print("Enter your guess: ");

                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += remainingAttempts * 10;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                remainingAttempts--;

            } while (attempts < MAX_ATTEMPTS && remainingAttempts > 0);

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            } else {

                randomNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            }
        }

        scanner.close();
    }
}
