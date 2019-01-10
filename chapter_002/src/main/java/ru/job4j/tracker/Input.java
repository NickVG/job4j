package ru.job4j.tracker;

/** Interface Input
 * Реализаци интерфейса Input
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
