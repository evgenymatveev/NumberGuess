import controller.GenerateNumberController;
import model.Game;
import view.ConsoleOutput;

import java.util.Random;

/**
 * @author Matveev Evgeny.
 */
public class Main {
    /**
     * Start of the game.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        ConsoleOutput input = new ConsoleOutput();
        do {
            Random random = new Random();
            GenerateNumberController g = new GenerateNumberController(random);
            int max = 10;
            int min = 1;
            int attempCount = 3;
            int target = g.generate(max);
            Game game = new Game.GameBuilder()
                    .max(max)
                    .min(min)
                    .attempCount(attempCount)
                    .target(target)
                    .createGame();
            input.check(input, game, g);
        } while ("y".equals(input.ask("Хотите еще сыграть? (y/n)")));
    }
}