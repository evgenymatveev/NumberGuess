package model;

/**
 * @author Matveev Evgeny.
 */
public class Game {

    private final int max;
    private final int min;
    private final int attemptCount;
    private final int target;

    /**
     * Please use {@link Game.GameBuilder} instead of the private constructor.
     * @param max value that the AI can choose.
     * @param min value that the AI can choose.
     * @param attemptCount amount of the attempts that the user will have
     *                     to guess the number.
     * @param target is the number that has been choose by the AI and need
     *               to be guessed by a player.
     */
    private Game(int max, int min, int attemptCount, int target) {
        this.max = max;
        this.min = min;
        this.attemptCount = attemptCount;
        this.target = target;
    }

    /**
     * max - ...
     */
    public int getMax() {
        return max;
    }

    /**
     * min - ...
     */
    public int getMin() {
        return min;
    }

    /**
     * ...
     */
    public int getAttemptCount() {
        return attemptCount;
    }

    /**
     * ...
     */
    public int getTarget() {
        return target;
    }

    /**
     * Builder for the {@link Game}. Please use the builder instead
     * of the direct {@link Game} instantiation.
     */
    public static class GameBuilder {

        private int max;
        private int min;
        private int attemptCount;
        private int target;

        /**
         * Constructor for Builder.
         * @param max max.
         * @return {@link GameBuilder}.
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
         * @param attempCount attemptCount.
         * @return GameBuilder.
         */
        public GameBuilder attempCount(int attempCount) {
            this.attemptCount = attempCount;
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
         * Creates new {@link Game} instance with the all variables
         * from the builder by passing to the constructor {@link Game#Game(int, int, int, int)}
         * @return a new instance of the class {@link Game}.
         */
        public Game createGame() {
            return new Game(max, min, attemptCount, target);
        }
    }
}
