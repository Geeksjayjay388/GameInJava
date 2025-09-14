import java.util.Scanner;
import java.util.Random;

public class WarmerColderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int target = rand.nextInt(100) + 1; // Random number between 1 and 100
        int guess = -1;
        int previousGuess = -1;
        int attempts = 0;

        System.out.println("🎯 Welcome to Warmer-Colder!");
        System.out.println("Try to guess the number between 1 and 100.");

        while (guess != target) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == target) {
                System.out.println("🔥 Correct! You guessed it in " + attempts + " attempts.");
                break;
            }

            if (previousGuess != -1) {
                int prevDiff = Math.abs(target - previousGuess);
                int currDiff = Math.abs(target - guess);

                if (currDiff < prevDiff) {
                    System.out.println("Warmer 🔥");
                } else if (currDiff > prevDiff) {
                    System.out.println("Colder ❄️");
                } else {
                    System.out.println("Same distance 🤷");
                }
            } else {
                System.out.println("Keep going...");
            }

            previousGuess = guess;
        }

        scanner.close();
    }
}
