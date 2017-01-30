import controller.GenerateNumberController;
import controller.NumberCheckerController;
import model.Game;
import view.ConsoleOutput;
import java.util.Random;


/**
 * Class Main to start the game.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class Main {
    /**
     * Start method main.
     * @param args args.
     */
    public static void main(String[] args) {
            ConsoleOutput input = new ConsoleOutput();
        do {
            Random random = new Random();
            GenerateNumberController g = new GenerateNumberController(random);
            NumberCheckerController n = new NumberCheckerController();
            int max = 10;
            int min = 2;
            int attempCount = 3;
            int target = g.generate(max, min);

            Game game = new Game.GameBuilder()
                    .max(max)
                    .min(min)
                    .attempCount(attempCount)
                    .target(target)
                    .createGame();
            n.check(input, game);
        } while ("y".equals(input.ask("Хотите еще сыграть? (y/n)")));
    }
}