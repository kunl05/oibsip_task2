import java.util.Random;
import javax.swing.JOptionPane;

public class GuessingNumber{
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 5;
        int userScore = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            // Generate a random number within the range
            Random random = new Random();
            int randomNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                // Prompt user to enter their guess
                String input = JOptionPane.showInputDialog("Guess the number (between " + rangeStart + " and " + rangeEnd + "):");
                int userGuess = Integer.parseInt(input);

                // Check if the user's guess is correct
                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Try again! The number is higher.");
                } else {
                    JOptionPane.showMessageDialog(null, "Try again! The number is lower.");
                }
                attempts++;
            }

            if (guessedCorrectly) {
                // Increment user's score and display round results
                userScore++;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you couldn't guess the number. The correct number was: " + randomNumber);
            }

            // Ask if the user wants to play again
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
            playAgain = (choice == JOptionPane.YES_OPTION);
        }

        // Display final score
        JOptionPane.showMessageDialog(null, "Your final score is: " + userScore);
    }
}
