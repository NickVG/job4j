package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Введённый ключ не является числом. Введите верный параметр");
            } catch (MenuOutException moe) {
                System.out.println("Введённый ключ неверен. Введите верный параметр показанный в меню");
            }
        } while (invalid);
        return value;
    }
}
