package ru.job4j.tracker;

/**
 * Interface Input
 * Реализаци интерфейса Input
 *
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.01
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
