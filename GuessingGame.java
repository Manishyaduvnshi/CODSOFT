import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;

        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (playAgain) {
            int guessedNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int numGuesses = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + lowerLimit + " and " + upperLimit + ". You have " + maxAttempts + " attempts to guess it.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Guess the number: ");
                int userGuess = scanner.nextInt();
                numGuesses++;

                if (userGuess < guessedNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > guessedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + guessedNumber + " correctly in " + numGuesses + " guesses.");
                    roundsWon++;
                    break;
                }
            }

            if (numGuesses >= maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + guessedNumber + ".");
            }

            totalAttempts += numGuesses;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing!");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);
    }
}
