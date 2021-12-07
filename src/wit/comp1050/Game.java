package wit.comp1050;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Game g = new Game();
        g.play();

    }

    public Game() {
        _maker = new CodeMaker();
        _player = new Player();
        _isActive = true;

    }


    public void play() {
        Code secret = _maker.makeCode(false);
        System.out.println("Welcome to Mastermind!");
        System.out.println("I have a secret code! Good luck!");

        Scanner scanner = new Scanner(System.in);

        String playerGuessString = "";
        while (_isActive) {
            System.out.println("What is your guess? ");
            playerGuessString = scanner.next();
            boolean isValid = inputValid(playerGuessString); //checks if valid user guess


            //call the method to convert string to code v

        }


        Code guess = new Code(playerGuessString); // "RRGB" -> 0012
        Score s = new Score(secret, guess);
    }




    private boolean inputValid(String userGuess) {
        if (userGuess.length() != Code.LENGTH) {
            System.out.println("Incorrect code length. Please enter 4 colors.");
            return false;
        }
        for (int i = 0; i < Code.LENGTH; i++) {
            char test = userGuess.charAt(i);

            if (test != '0' && test != '1' && test != '2' && test != '3' && test != '4' && test != '5') {
                System.out.println("Please enter a valid code number (0-4).");
                return false;
            }
        }
        return true;
    }


    private final CodeMaker _maker;
    private final Player _player;
    private final boolean _isActive;

}
