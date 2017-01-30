package controller;

import java.util.Random;

/**
 * Class GenerateNumberController for generate the number.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class GenerateNumberController {
    /**
     * Random.
     */
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
     * @param max max.
     * @param min min.
     * @return int random.
     */
    public int generate(final int max, final int min) {
        final int size = max - min;
        final int randomValue = random.nextInt() % size;
        return min + randomValue;
    }
}
