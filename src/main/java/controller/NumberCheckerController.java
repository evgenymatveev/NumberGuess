package controller;

import model.Game;
import model.GuessResult;
import view.ConsoleOutput;

/**
 * Class NumberCheckerController for comparison of the number of hidden and entered by the user.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class NumberCheckerController {
    /**
     * Method numberEqualityCheck() for comparison of the number of hidden and entered by the user.
     * @param guess guess.
     * @param target target.
     * @return enum GuessResult.
     */
    public static GuessResult numberEqualityCheck(final int guess, final int target) {
        if (guess > target) {
            return GuessResult.GUESS_IS_BIGGER;
        } else if (guess < target) {
            return GuessResult.GUESS_IS_SMALL;
        }
        return GuessResult.EQUAL;
    }

    /**
     * Method check().
     * @param input input.
     * @param game game.
     */
    public void check(ConsoleOutput input, Game game) {
        do {
            System.out.println("Число загадано, введите ваше в диапазоне от" + " "
                    + game.getMin() + " "
                    + "до" + " "
                    + game.getMax() + "." + " "
                    + "Количество попыток" + " "
                    + game.getAttempCount() + ".");
            for (int i = 0; i < game.getAttempCount(); i++) {

                int key = Integer.parseInt(input.ask());

                if (numberEqualityCheck(key, game.getTarget()) == GuessResult.GUESS_IS_BIGGER) {
                    System.out.println("Ваше число больше. Осталось попыток -" + " " + (game.getAttempCount() - 1 - i));
                } else if (NumberCheckerController.numberEqualityCheck(key, game.getTarget()) == GuessResult.GUESS_IS_SMALL) {
                    System.out.println("Ваше число меньше. Осталось попыток -" + " " + (game.getAttempCount() - 1 - i));
                } else if ((NumberCheckerController.numberEqualityCheck(key, game.getTarget()) == GuessResult.EQUAL)) {
                    System.out.println("Вы угадали!");
                    break;
                }
            }
        } while ("y".equals(input.ask("Хотите еще сыграть? (y/n)")));
    }
}

