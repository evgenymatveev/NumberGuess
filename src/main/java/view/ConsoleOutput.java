package view;

import controller.GenerateNumberController;
import model.Game;
import model.GuessResult;

import java.util.Scanner;

/**
 * @author Matveev Evgeny.
 */
public class ConsoleOutput {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method for a request from the user of the number.
     *
     * @return the response from the user.
     */
    public String ask() {
        return scanner.nextLine();
    }

    /**
     * Method for questions the user about exit or continue of the game.
     *
     * @param question for user.
     * @return the response from the user.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Method prints to the console all the questions and answers..
     *
     * @param input                    console.
     * @param game                     install the game.
     * @param generateNumberController generate the number.
     */
    public void check(ConsoleOutput input, Game game, GenerateNumberController generateNumberController) {
        System.out.println("Число загадано, введите ваше в диапазоне от" + " "
                + game.getMin() + " "
                + "до" + " "
                + game.getMax() + "." + " "
                + "Количество попыток" + " "
                + game.getAttemptCount() + ".");
        for (int i = 0; i < game.getAttemptCount(); i++) {
            int key = Integer.parseInt(input.ask());
            final GuessResult result = generateNumberController.numberEqualityCheck(key, game.getTarget());
            if (result == GuessResult.GUESS_IS_BIGGER) {
                System.out.println("Ваше число больше. Осталось попыток:" + " " + (game.getAttemptCount() - 1 - i));
            } else if (result == GuessResult.GUESS_IS_SMALL) {
                System.out.println("Ваше число меньше. Осталось попыток:" + " " + (game.getAttemptCount() - 1 - i));
            } else if (result == GuessResult.EQUAL) {
                System.out.println("Вы угадали!");
                break;
            }
        }
    }
}
