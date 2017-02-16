package view;

import controller.GenerateNumberController;
import model.Game;
import model.GuessResult;

import java.util.Scanner;

/**
 * Class ConsoleOutput for output the console.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class ConsoleOutput {
    private Scanner scanner = new Scanner(System.in);
    /**
     * Method ask() to questions for user.
     * @return String
     */
    public String ask() {
        return scanner.nextLine();
    }
    /**
     * Method ask() to questions for user.
     * @param question question.
     * @return String.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Method check().
     *
     * @param input input.
     * @param game game.
     * @param generateNumberController generateNumberController.
     */
    public void check(ConsoleOutput input, Game game, GenerateNumberController generateNumberController) {
        System.out.println("Число загадано, введите ваше в диапазоне от" + " "
                + game.getMin() + " "
                + "до" + " "
                + game.getMax() + "." + " "
                + "Количество попыток" + " "
                + game.getAttempCount() + ".");

        for (int i = 0; i < game.getAttempCount(); i++) {

            int key = Integer.parseInt(input.ask());

            final GuessResult result = generateNumberController.numberEqualityCheck(key, game.getTarget());

            if (result == GuessResult.GUESS_IS_BIGGER) {
                System.out.println("Ваше число больше. Осталось попыток -" + " " + (game.getAttempCount() - 1 - i));
            } else if (result == GuessResult.GUESS_IS_SMALL) {
                System.out.println("Ваше число меньше. Осталось попыток -" + " " + (game.getAttempCount() - 1 - i));
            } else if (result == GuessResult.EQUAL) {
                System.out.println("Вы угадали!");
                break;
            }
        }
    }
}
