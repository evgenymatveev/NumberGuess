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
     * @throws NumberFormatException will generate an exception if the user enters not a whole number.
     */
    public String ask() throws NumberFormatException {
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
        int numberOfattempts = game.getAttemptCount();
        System.out.println("Число загадано, введите ваше в диапазоне от" + " "
                + game.getMin() + " "
                + "до" + " "
                + game.getMax() + "." + " "
                + "Количество попыток" + " "
                + numberOfattempts + ".");
        try {
            for (int i = 0; i < game.getAttemptCount(); i++) {
                int index = numberOfattempts - 1 - i;
                int key = Integer.parseInt(input.ask());
                final GuessResult result = GenerateNumberController.numberEqualityCheck(key, game.getTarget());

                if (result == GuessResult.GUESS_IS_BIGGER) {
                    System.out.println("Ваше число больше. Осталось попыток:" + " " + index);
                } else if (result == GuessResult.GUESS_IS_SMALL) {
                    System.out.println("Ваше число меньше. Осталось попыток:" + " " + index);
                }
                if (result == GuessResult.EQUAL) {
                    System.out.println("Вы угадали!");
                    break;
                } else {
                    if (index == 0) {
                        System.out.println("Вы не угадали!)");
                        break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Вводите только целые числа!");
        }
    }
}
