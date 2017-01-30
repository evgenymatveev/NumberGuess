package view;

import java.util.Scanner;

/**
 * Class ConsoleOutput for output the console.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 30.01.17.
 */
public class ConsoleOutput {
    /**
     * Scanner for output the console.
     */
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
}
