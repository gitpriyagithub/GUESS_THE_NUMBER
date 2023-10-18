import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 10;
        int score = 0;
        
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");
        
        while (numberOfAttempts > 0) {
            String input = JOptionPane.showInputDialog("Guess the number between " + lowerBound + " and " + upperBound);
            
            if (input == null) {
                // User clicked Cancel or closed the dialog
                JOptionPane.showMessageDialog(null, "Thanks for playing! Your final score is: " + score);
                System.exit(0);
            }
            
            try {
                int guessedNumber = Integer.parseInt(input);
                
                if (guessedNumber < lowerBound || guessedNumber > upperBound) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between " + lowerBound + " and " + upperBound);
                    continue;
                }
                
                if (guessedNumber == randomNumber) {
                    score += numberOfAttempts * 10;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number. Your current score: " + score);
                    break;
                } else if (guessedNumber < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
                
                numberOfAttempts--;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
        
        JOptionPane.showMessageDialog(null, "Thanks for playing! Your final score is: " + score);
    }
}

