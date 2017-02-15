package controller;

import model.GuessResult;

import java.util.Random;

/**
 * Class GenerateNumberController for generate the number.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class GenerateNumberController {
    private Random random;
    /**
     * Constructor.
     * @param random int random.
     */
    public GenerateNumberController(Random random) {
        this.random = random;
    }
    /**
     * Method generate for generate the number.
     * @param n n.
     * @return int random.
     */
    public int generate(final int n) {
        return random.nextInt(n) + 1;
    }
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
}

//    public int generate(final int max, final int min) {
//        final int size = max - min;
//        final int randomValue = random.nextInt() % size;
//        return min + randomValue;
//    }