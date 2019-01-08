package ru.job4j.tracker;
import java.lang.*;
import java.util.Scanner;

/** Class ConsoleInput
 * Реализаци якласса ConsoleInput
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu reange.");
        }
    }
}