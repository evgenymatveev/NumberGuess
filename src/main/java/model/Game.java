package model;

/**
 * Class Game.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class Game {
    /**
     * Max value.
     */
    private final int max;
    /**
     * Min value.
     */
    private final int min;
    /**
     * The number of attempts.
     */
    private final int attempCount;
    /**
     * Unknown number.
     */
    private final int target;

    /**
     * Constructor.
     * @param max max.
     * @param min min.
     * @param attempCount attempCount.
     * @param target target.
     */
    private Game(int max, int min, int attempCount, int target) {
        this.max = max;
        this.min = min;
        this.attempCount = attempCount;
        this.target = target;
    }

    /**
     * Getter for max.
     * @return max.
     */
    public int getMax() {
        return max;
    }

    /**
     * Getter for min.
     * @return min.
     */
    public int getMin() {
        return min;
    }

    /**
     * Getter for attempCount.
     * @return attempCount
     */
    public int getAttempCount() {
        return attempCount;
    }

    /**
     * Getter for unknown number.
     * @return target
     */
    public int getTarget() {
        return target;
    }

    /**
     * Builder for game.
     */
    public static class GameBuilder {
        /**
         * Max value.
         */
        private int max;
        /**
         * Min value.
         */
        private int min;
        /**
         * The number of attempts.
         */
        private int attempCount;
        /**
         * Unknown number.
         */
        private int target;

        /**
         * Constructor for Builder.
         * @param max max.
         * @return GameBuilder.
         */
        public GameBuilder max(int max) {
            this.max = max;
            return this;
        }

        /**
         * Constructor for Builder.
         * @param min min.
         * @return GameBuilder.
         */
        public GameBuilder min(int min) {
            this.min = min;
            return this;
        }

        /**
         * Constructor for Builder.
         * @param attempCount attempCount.
         * @return GameBuilder.
         */
        public GameBuilder attempCount(int attempCount) {
            this.attempCount = attempCount;
            return this;
        }

        /**
         * Constructor for Builder.
         * @param target target.
         * @return GameBuilder.
         */
        public GameBuilder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * Method createGame.
         * @return this Game.
         */
        public Game createGame() {
            return new Game(max, min, attempCount, target);
        }
    }
}
