package ru.job4j.tracker;

/** Class ValidateInput
 * Реализация класса ValidateInput для обработки исключений
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.01
 */

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return  value;
    }
}

/*public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введённый ключ неверен. Введите верный параметр как показано в меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введённый ключ не является числом. Введите верный параметр как показано в меню.");
            }
        } while (invalid);
        return value;
    }
}*/