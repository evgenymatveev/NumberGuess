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
    public void check(final ConsoleOutput input, final Game game) {
        System.out.println("Число загадано, введите ваше в диапазоне от" + " "
                + game.getMin() + " "
                + "до" + " "
                + game.getMax() + "." + " "
                + "Количество попыток" + " "
                + game.getAttemptCount() + ".");

        for (int i = 0; i < game.getAttemptCount(); i++) {

            int key = Integer.parseInt(input.ask());

            final GuessResult result = numberEqualityCheck(key, game.getTarget());
            if (result == GuessResult.GUESS_IS_BIGGER) {
                System.out.println("Ваше число больше. Осталось попыток -" + " " + (game.getAttemptCount() - 1 - i));
            } else if (result == GuessResult.GUESS_IS_SMALL) {
                System.out.println("Ваше число меньше. Осталось попыток -" + " " + (game.getAttemptCount() - 1 - i));
            } else if (result == GuessResult.EQUAL) {
                System.out.println("Вы угадали!");
                break;
            }
        }
    }
}

